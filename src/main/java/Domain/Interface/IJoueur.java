package Domain.Interface;

import Util.IDomainObject;

public interface IJoueur extends IDomainObject {

    public IUser getUser();

    public void setUser(IUser user);

    public IGame getGame();

    public void setGame(IGame game);

    public Integer getRessource();

    public void setRessource(Integer ressource);
}
