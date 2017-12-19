package Jeu.Interface;

import Jeu.Entity.Coordonnees;
import Jeu.Entity.Type;

public interface ITerritoire {

    public void setId(Integer id);

    public Integer getId();

    public Type getType();

    public void setType(Type type);

    public Coordonnees getCoordonnees();

    public void setCoordonnees(Coordonnees coordonnees);

    public IVille getVilles();

    public void setVilles(IVille villes);

    public IUser getOwner();

    public void setOwner(IUser owner);

}
