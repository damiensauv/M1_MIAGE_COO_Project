package Jeu.Entity;

import Jeu.Interface.ICarte;
import Util.Observer;
import Util.Visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Carte extends AObject implements ICarte {

    private Territoire[][] carte;
    private List<Ville> listeVilles;
    private List<Armee> listeArmee;

    // TODO : revoir le constuctor
    public Carte(int sizeX, int sizeY) {
        int randomInt;

        this.listeArmee = new ArrayList<Armee>();
        this.listeVilles = new ArrayList<Ville>();

        this.carte = new Territoire[sizeX][sizeY];

        // Il nous faut un nombre aléatoire pour générer les cases de la map
        Random randomGenerator = new Random();

        // On crée la carte ligne par ligne
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                randomInt = randomGenerator.nextInt(3);
                this.setTerritoire(new Coordonnees(i, j), randomInt);
            }
        }
    }

    public void setTerritoire(Coordonnees coord, int type) {
        int xpos = coord.getX();
        int ypos = coord.getY();

        switch (type) {
            case 0:
                this.carte[xpos][ypos] = new Plaine(coord);
                break;
            case 1:
                this.carte[xpos][ypos] = new Champ(coord);
                break;
            case 2:
                this.carte[xpos][ypos] = new Montagne(coord);
                break;
            default:
                break;
        }
        notifier();
    }

    public Territoire[][] getCarte() {
        return carte;
    }

    public void setCarte(Territoire[][] carte) {
        this.carte = carte;
        notifier();
    }

    public List<Ville> getListeVilles() {
        return listeVilles;
    }

    public void addVille(Ville ville) {
        this.listeVilles.add(ville);
        notifier();
    }

    public void setListeVilles(List<Ville> listeVilles) {
        this.listeVilles = listeVilles;
        notifier();
    }

    public List<Armee> getListeArmee() {
        return listeArmee;
    }

    public void addArmee(Armee armee) {
        this.listeArmee.add(armee);
        notifier();
    }

    public void setListeArmee(List<Armee> listeArmee) {
        this.listeArmee = listeArmee;
        notifier();
    }

    public void AfficherCarteDebug() {
        for (int i = 0; i < this.carte.length; i++) {
            for (int j = 0; j < this.carte[i].length; j++) {
                this.carte[i][j].AfficherTypeTerritoire();
            }
            System.out.println("");
        }
    }

    public void add(Observer o) {
        obs.add(o);
    }

    public void notifier() {
        for (Observer o : obs)
            o.action(this);
    }

    public void accept(Visitor v) {
        v.visiter(this);
    }
}
