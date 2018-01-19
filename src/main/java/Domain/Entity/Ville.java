package Domain.Entity;

import Domain.Interface.ICarte;
import Domain.Interface.IUser;
import Domain.Interface.IVille;
import Util.Observer;
import Util.UnitOfWork;
import Util.Visitor;

public class Ville extends AObject implements IVille {

    private IUser user;
    private ICarte carte;

    public Ville(IUser joueur, ICarte carte) {
        this.user = joueur;
        this.carte = carte;
        this.add(UnitOfWork.getInstance());
    }

    public IUser getJoueur() {
        return user;
    }

    public void setJoueur(IUser user) {
        this.user = user;
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

    public ICarte getCarte() {
        return carte;
    }

    public void setCarte(ICarte carte) {
        this.carte = carte;
    }
}


