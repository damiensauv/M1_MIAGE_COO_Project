package Jeu.Interface;

import Jeu.Entity.Armee;
import Jeu.Entity.Coordonnees;
import Jeu.Entity.Territoire;
import Jeu.Entity.Ville;
import Util.IDomainObject;

import java.util.List;

public interface ICarte extends IDomainObject {

    void setTerritoire(Coordonnees coord, int type);

    Territoire[][] getCarte();

    void setCarte(Territoire[][] carte);

    List<Ville> getListeVilles();

    void addVille(Ville ville);

    void setListeVilles(List<Ville> listeVilles);

    List<Armee> getListeArmee();

    void addArmee(Armee armee);

    void setListeArmee(List<Armee> listeArmee);

    void AfficherCarteDebug();
}
