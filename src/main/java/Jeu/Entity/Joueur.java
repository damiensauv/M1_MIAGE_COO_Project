package Jeu.Entity;

import Jeu.Interface.IGame;
import Jeu.Interface.IJoueur;
import Jeu.Interface.IUser;
import Util.Observer;
import Util.Visitor;

public class Joueur extends AObject implements IJoueur {

    private IUser user;
    private IGame game;

    // ajouter les infos in Game du player

    public IUser getUser() {
        return user;
    }

    public void setUser(IUser user) {
        this.user = user;
    }

    public IGame getGame() {
        return game;
    }

    public void setGame(IGame game) {
        this.game = game;
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
