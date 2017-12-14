package Jeu.Entity;

import Jeu.Interface.ICarte;
import Jeu.Interface.IJoueur;
import Jeu.Interface.IVille;
import Util.Observer;
import Util.Visitor;

public class Ville extends AObject implements IVille {

    private ICarte carte;
    private IJoueur joueur;
    private Coordonnees coordonnees;

    public Ville(ICarte carte, IJoueur joueur, Coordonnees coordonnees) {
        this.carte = carte;
        this.joueur = joueur;
        this.coordonnees = coordonnees;
    }

    public IJoueur getJoueur() {
        return joueur;
    }

    public void setJoueur(IJoueur joueur) {
        this.joueur = joueur;
        notifier();
    }

    public ICarte getCarte() {
        return carte;
    }

    public void setCarte(ICarte carte) {
        this.carte = carte;
        notifier();
    }

    public Coordonnees getCoordonnees() {
        return coordonnees;
    }

    public void setCoordonnees(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
        notifier();
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
