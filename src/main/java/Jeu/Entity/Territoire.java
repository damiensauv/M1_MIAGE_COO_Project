package Jeu.Entity;

import Jeu.Interface.ITerritoire;
import Jeu.Interface.IUser;
import Jeu.Interface.IVille;
import Util.Observer;
import Util.UnitOfWork;
import Util.Visitor;

import java.util.List;

public abstract class Territoire extends AObject implements ITerritoire {

    private Coordonnees coordonnees;

    private IVille villes;

    private IUser owner;

    // add arme and owner de la case

    private Type type;

    public Territoire(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
        this.add(UnitOfWork.getInstance());
    }

    public Coordonnees getCoordonnees() {
        return coordonnees;
    }

    public void setCoordonnees(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
        notifier();
    }

    public abstract void AfficherTypeTerritoire();

    public abstract Type getType();

    public void setType(Type type) {
        this.type = type;
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
        v.visiter((ITerritoire) this);
    }
}
