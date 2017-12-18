package Jeu.Interface;

import Jeu.Entity.Coordonnees;
import Jeu.Entity.Type;

public interface ITerritoire {

    public void setId(Integer id);

    public Integer getId();

    Type getType();

    public void setType(Type type);

    Coordonnees getCoordonnees();

    public void setCoordonnees(Coordonnees coordonnees);

}
