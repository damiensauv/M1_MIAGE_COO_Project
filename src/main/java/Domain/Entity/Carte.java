package Domain.Entity;

import Domain.Interface.ICarte;
import Util.Observer;
import Util.UnitOfWork;
import Util.Visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Carte extends AObject implements ICarte {

    private List<Territoire> territoires;

    private String seed;

    public Carte(Coordonnees coo) {
        int randomInt;
        int sizeX = coo.getX();
        int sizeY = coo.getY();

        this.territoires = new ArrayList<Territoire>();

        // Il nous faut un nombre aléatoire pour générer les cases de la map
        Random randomGenerator = new Random();

        // On crée la carte ligne par ligne
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                randomInt = randomGenerator.nextInt(3);
                this.setTerritoire(new Coordonnees(i, j), randomInt);
            }
        }
        this.add(UnitOfWork.getInstance());
    }

    public Carte(int id, String seed, List<Territoire> territoires) {
        this.setId(id);
        this.seed = seed;
        this.territoires = territoires;
    }

    public void setTerritoire(Coordonnees coord, int type) {

        switch (type) {
            case 0:
                this.territoires.add(new Plaine(coord, null, null));
                break;
            case 1:
                this.territoires.add(new Champ(coord, null, null));
                break;
            case 2:
                this.territoires.add(new Montagne(coord, null, null));
                break;
            default:
                break;
        }
    }

    public List<Territoire> getTerritoires() {
        return territoires;
    }

    public void setTerritoires(List<Territoire> carte) {
        this.territoires = carte;
        notifier();
    }

    public void AfficherCarteDebug() {
        /*for (int i = 0; i < this.territoires.length; i++) {
            for (int j = 0; j < this.territoires[i].length; j++) {
                this.territoires[i][j].AfficherTypeTerritoire();
            }
            System.out.println("");
        }*/
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

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
        notifier();
    }
}
