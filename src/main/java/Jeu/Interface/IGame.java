package Jeu.Interface;

import Jeu.Entity.Carte;
import Jeu.Entity.Coordonnees;
import Jeu.Entity.User;
import Util.IDomainObject;

import java.util.List;

public interface IGame extends IDomainObject {

    public void setId(Integer id);

    public Integer getId();

    public String getName();

    public void setName(String name);

    public boolean isStatus();

    public void setStatus(boolean status);

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

    public Carte getCarte();

    public void setCarte(Carte carte);

    public Integer getCurrentTurn();

    public void setCurrentTurn(Integer currentTurn);

    public List<User> getUserInGame();

    public void setUserInGame(List<User> userInGame);

}
