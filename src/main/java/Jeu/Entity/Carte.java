package Jeu.Entity;

import Jeu.Interface.ICarte;
import Jeu.Interface.IVille;
import Util.Observer;
import Util.Visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Carte extends AObject implements ICarte {

    private Territoire[][] carte;

    public Carte(Coordonnees coo) {
        int randomInt;
        int sizeX = coo.getX();
        int sizeY = coo.getY();

        this.carte = new Territoire[sizeX][sizeY];

        // Il nous faut un nombre aléatoire pour générer les cases de la map
        Random randomGenerator = new Random();

        // On crée la carte ligne par ligne
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
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
