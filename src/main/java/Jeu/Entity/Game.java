package Jeu.Entity;

import Jeu.Interface.IGame;

import java.util.List;

public class Game extends AObject implements IGame {

    private String name;
    private boolean status;// en cours ou pas
    private User owner; // Automatic dans les UserInGame ??
    private User winner;

    // Game Option
    private Integer mapSize;
    private Integer maxUser;
    private Integer NbInitRes;
    private Integer NbResTurn;
    private Integer timeTurn;

    private Carte carte; // Tout les donnes sur letat de la carte sont dedans

    private Integer currentTurn;
    private List<User> userInGame; // Table asso Id-Game, Id-User, Point Ressources

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
        notifier();
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
        notifier();
    }

    public User getWinner() {
        return winner;
    }

    public void setWinner(User winner) {
        this.winner = winner;
        notifier();
    }

    public Integer getMapSize() {
        return mapSize;
    }

    public void setMapSize(Integer mapSize) {
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
    }
    
}
