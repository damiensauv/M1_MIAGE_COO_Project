package Domain.Interface;

import Domain.Entity.Coordonnees;
import Util.IDomainObject;

public interface IArmee extends IDomainObject {

    Coordonnees getCoordonnees();

    void setCoordonnees(Coordonnees coordonnees);

    ICarte getCarte();

    void setCarte(ICarte carte);

    IJoueur getJoueur();

    void setJoueur(IJoueur joueur);

}
