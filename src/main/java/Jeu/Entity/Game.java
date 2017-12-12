package Jeu.Entity;

import Jeu.Interface.IGame;
import Jeu.Interface.IUser;
import Util.Observer;
import Util.Visitor;

import java.util.List;

public class Game extends AObject implements IGame {


    private String name;
    private boolean status = false;// en cours ou pas
    private IUser owner; // Automatic dans les UserInGame ??
    private IUser winner;

    // Game Option
    private Coordonnees mapSize;
    private Integer maxUser;
    private Integer NbInitRes;
    private Integer NbResTurn;
    private Integer timeTurn;

    private Carte carte; // Tout les donnes sur letat de la carte sont dedans

    private Integer currentTurn = 0;
    private List<User> userInGame; // Table asso Id-Game, Id-User, Point Ressources

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
        notifier();
    }

    public IUser getOwner() {
        return owner;
    }

    public void setOwner(IUser owner) {
        this.owner = owner;
        notifier();
    }

    public IUser getWinner() {
        return winner;
    }

    public void setWinner(IUser winner) {
        this.winner = winner;
        notifier();
    }

    public Coordonnees getMapSize() {
        return mapSize;
    }

    public void setMapSize(Coordonnees mapSize) {
        this.mapSize = mapSize;
        notifier();
    }

    public Integer getMaxUser() {
        return maxUser;
    }

    public void setMaxUser(Integer maxUser) {
        this.maxUser = maxUser;
        notifier();
    }

    public Integer getNbInitRes() {
        return NbInitRes;
    }

    public void setNbInitRes(Integer nbInitRes) {
        NbInitRes = nbInitRes;
        notifier();
    }

    public Integer getNbResTurn() {
        return NbResTurn;
    }

    public void setNbResTurn(Integer nbResTurn) {
        NbResTurn = nbResTurn;
        notifier();
    }

    public Integer getTimeTurn() {
        return timeTurn;
    }

    public void setTimeTurn(Integer timeTurn) {
        this.timeTurn = timeTurn;
        notifier();
    }

    public Carte getCarte() {
        return carte;
    }

    public void setCarte(Carte carte) {
        this.carte = carte;
        notifier();
    }

    public Integer getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(Integer currentTurn) {
        this.currentTurn = currentTurn;
        notifier();
    }

    public List<User> getUserInGame() {
        return userInGame;
    }

    public void setUserInGame(List<User> userInGame) {
        this.userInGame = userInGame;
        notifier();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifier();
    }

    public void add(Observer o) {
        this.obs.add(o);
    }

    public void notifier() {
        for (Observer o : this.obs)
            o.action(this);
    }

    public void accept(Visitor v) {
        v.visiter(this);
    }

}
