package Jeu.Interface;

import Jeu.Entity.Carte;
import Jeu.Entity.Coordonnees;
import Jeu.Entity.Status;
import Util.IDomainObject;

import java.util.List;

public interface IGame extends IDomainObject {

    public void setId(Integer id);

    public Integer getId();

    public String getName();

    public void setName(String name);

    public Status getStatus();

    public void setStatus(Status status);

    public IUser getOwner();

    public void setOwner(IUser owner);

    public IUser getWinner();

    public void setWinner(IUser winner);

    public Coordonnees getMapSize();

    public void setMapSize(Coordonnees mapSize);

    public Integer getMaxUser();

    public void setMaxUser(Integer maxUser);

    public Integer getNbInitRes();

    public void setNbInitRes(Integer nbInitRes);

    public Integer getNbResTurn();

    public void setNbResTurn(Integer nbResTurn);

    public Integer getTimeTurn();

    public void setTimeTurn(Integer timeTurn);

    public ICarte getCarte();

    public void setCarte(ICarte carte);

    public Integer getCurrentTurn();

    public void setCurrentTurn(Integer currentTurn);

    public void addUserInGame(IJoueur joueur);

    public List<IJoueur> getUserInGame();

    public void setUserInGame(List<IJoueur> userInGame);

    public Integer getDistanceMinVille();

    public void setDistanceMinVille(Integer distanceMinVille);

}
