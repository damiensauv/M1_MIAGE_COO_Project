package Jeu.Interface;

import Jeu.Entity.Coordonnees;
import Util.IDomainObject;

public interface IVille extends IDomainObject {

    IJoueur getJoueur();

    void setJoueur(IJoueur joueur);

    ICarte getCarte();

    void setCarte(ICarte carte);

    Coordonnees getCoordonnees();

    void setCoordonnees(Coordonnees coordonnees);
}
