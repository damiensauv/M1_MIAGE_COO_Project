package Jeu.Entity;

import Jeu.Interface.ICarte;
import Jeu.Interface.IGame;
import Jeu.Interface.IJoueur;
import Jeu.Interface.IUser;
import Util.Observer;
import Util.UnitOfWork;
import Util.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Game extends AObject implements IGame {

    private String name;
    private Status status = Status.awayting;
    private IUser owner;
    private IUser winner;

    // Game Option
    private Coordonnees mapSize;
    private Integer maxUser;
    private Integer NbInitRes;
    private Integer NbResTurn;
    private Integer timeTurn;
    private Integer distanceMinVille;

    private ICarte carte; // Tout les donnes sur letat de la carte sont dedans

    private Integer currentTurn = 0;
    private List<IJoueur> userInGame; // Table asso Id-Game, Id-User, Point Ressources

    public Game(String name, Status status, IUser owner, Coordonnees mapSize, Integer maxUser, Integer nbInitRes, Integer nbResTurn, Integer timeTurn, Integer distanceMinVille, ICarte carte) {
        this.name = name;
        this.status = status;
        this.owner = owner;
        this.mapSize = mapSize;
        this.maxUser = maxUser;
        this.NbInitRes = nbInitRes;
        this.NbResTurn = nbResTurn;
        this.timeTurn = timeTurn;
        this.distanceMinVille = distanceMinVille;
        this.carte = carte;
        this.userInGame = new ArrayList<IJoueur>();
        this.add(UnitOfWork.getInstance());
    }

    public Game(Integer id, String name, Status status, IUser owner, IUser winner, Coordonnees mapSize, Integer maxUser, Integer nbInitRes, Integer nbResTurn, Integer timeTurn, Integer distanceMinVille, ICarte carte, Integer currentTurn, List<IJoueur> userInGame) {
        this.setId(id);
        this.name = name;
        this.status = status;
        this.owner = owner;
        this.winner = winner;
        this.mapSize = mapSize;
        this.maxUser = maxUser;
        this.NbInitRes = nbInitRes;
        this.NbResTurn = nbResTurn;
        this.timeTurn = timeTurn;
        this.distanceMinVille = distanceMinVille;
        this.carte = carte;
        this.currentTurn = currentTurn;
        if (userInGame == null)
            this.userInGame = new ArrayList<IJoueur>();
        else
            this.userInGame = userInGame;
        this.add(UnitOfWork.getInstance());
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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

    public ICarte getCarte() {
        return carte;
    }

    public void setCarte(ICarte carte) {
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

    public List<IJoueur> getUserInGame() {
        return userInGame;
    }

    public void addUserInGame(IJoueur joueur) {
        this.userInGame.add(joueur);
    }

    public void setUserInGame(List<IJoueur> userInGame) {
        this.userInGame = userInGame;
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

    @Override
    public String toString() {
        return name + " | [" + this.userInGame.size() + "/" + maxUser + "]";
    }

    public Integer getDistanceMinVille() {
        return distanceMinVille;
    }

    public void setDistanceMinVille(Integer distanceMinVille) {
        this.distanceMinVille = distanceMinVille;
        notifier();
    }
}
