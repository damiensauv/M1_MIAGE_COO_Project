package Domain.Entity;

import Domain.Interface.ITerritoire;
import Domain.Interface.IUser;
import Domain.Interface.IVille;
import Util.Observer;
import Util.UnitOfWork;
import Util.Visitor;

public abstract class Territoire extends AObject implements ITerritoire {

    private Coordonnees coordonnees;

    protected IVille villes = null;

    protected IUser owner;

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
    }

    public abstract void AfficherTypeTerritoire();

    public abstract Type getType();

    public void setType(Type type) {
        this.type = type;
    }

    public IVille getVilles() {
        return villes;
    }

    public void setVilles(IVille villes) {
        this.villes = villes;
        notifier();
    }

    public IUser getOwner() {
        return owner;
    }

    public void setOwner(IUser owner) {
        this.owner = owner;
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
