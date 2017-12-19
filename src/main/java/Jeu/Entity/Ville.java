package Jeu.Entity;

import Jeu.Interface.IUser;
import Jeu.Interface.IVille;
import Util.Observer;
import Util.UnitOfWork;
import Util.Visitor;

public class Ville extends AObject implements IVille {

    private IUser user;

    public Ville(IUser joueur) {
        this.user = joueur;
        this.add(UnitOfWork.getInstance());
    }

    public IUser getJoueur() {
        return user;
    }

    public void setJoueur(IUser user) {
        this.user = user;
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


