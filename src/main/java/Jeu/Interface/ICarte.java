package Jeu.Interface;

import Jeu.Entity.Coordonnees;
import Jeu.Entity.Territoire;
import Util.IDomainObject;

import java.util.List;

public interface ICarte extends IDomainObject {

    public void setTerritoire(Coordonnees coord, int type);

    public List<Territoire> getTerritoires();

    public void setTerritoires(List<Territoire> carte);

    public void AfficherCarteDebug();

    public String getSeed();

    public void setSeed(String seed);
}
