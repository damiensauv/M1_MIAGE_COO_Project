package Jeu.Interface;

import Jeu.Entity.Armee;
import Jeu.Entity.Coordonnees;
import Jeu.Entity.Territoire;
import Jeu.Entity.Ville;
import Util.IDomainObject;

import java.util.List;

public interface ICarte extends IDomainObject {

    public void setTerritoire(Coordonnees coord, int type);

    public Territoire[][] getCarte();

    public void setCarte(Territoire[][] carte);

    public void AfficherCarteDebug();
}
