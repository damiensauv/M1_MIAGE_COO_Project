package Domain.Interface;

import Util.IDomainObject;

public interface IVille extends IDomainObject {

    IUser getJoueur();

    void setJoueur(IUser joueur);

    public ICarte getCarte();

    public void setCarte(ICarte carte);
}
