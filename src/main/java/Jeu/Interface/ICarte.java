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

    public List<Ville> getListeVilles();

    public void addVille(Ville ville);

    public void setListeVilles(List<Ville> listeVilles);

    public List<Armee> getListeArmee();

    public void addArmee(Armee armee);

    public void setListeArmee(List<Armee> listeArmee);

    public void AfficherCarteDebug();
}
