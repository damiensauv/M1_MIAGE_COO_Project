package Jeu.Entity;

import Jeu.Interface.IArmee;
import Jeu.Interface.ICarte;
import Jeu.Interface.IJoueur;
import Util.Observer;
import Util.Visitor;

public class Armee extends AObject implements IArmee {

    private ICarte carte;
    private IJoueur joueur;
    private Coordonnees coordonnees;

    public Armee(IJoueur joueur, Coordonnees coordonnees) {
        this.joueur = joueur;
        this.coordonnees = coordonnees;
    }

    public Coordonnees getCoordonnees() {
        return coordonnees;
    }

    public void setCoordonnees(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
    }

    public ICarte getCarte() {
        return carte;
    }

    public void setCarte(ICarte carte) {
        this.carte = carte;
    }

    public IJoueur getJoueur() {
        return joueur;
    }

    public void setJoueur(IJoueur joueur) {
        this.joueur = joueur;
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
