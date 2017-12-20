package Jeu.Entity;

import Jeu.Interface.IGame;
import Jeu.Interface.IJoueur;
import Jeu.Interface.IUser;
import Util.Observer;
import Util.UnitOfWork;
import Util.Visitor;

public class Joueur extends AObject implements IJoueur {

    private IUser user;
    private IGame game;
    private Integer ressource = 0;

    // ajouter les infos in Game du player
    public Joueur(){
        this.add(UnitOfWork.getInstance());

    }

    public Joueur(IUser user, IGame game) {
        this.user = user;
        this.game = game;
        this.add(UnitOfWork.getInstance());
    }

    public Joueur(IGame id_game, IUser id_user, int ressource) {
        this.setGame(id_game);
        this.setUser(id_user);
        this.setRessource(ressource);
        this.add(UnitOfWork.getInstance());
    }



    public IUser getUser() {
        return user;
    }

    public void setUser(IUser user) {
        this.user = user;
        notifier();
    }

    public IGame getGame() {
        return game;
    }

    public void setGame(IGame game) {
        this.game = game;
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

    public Integer getRessource() {
        return ressource;
    }

    public void setRessource(Integer ressource) {
        this.ressource = ressource;
        notifier();
    }
}
