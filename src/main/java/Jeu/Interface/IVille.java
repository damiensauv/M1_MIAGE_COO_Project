package Jeu.Interface;

import Util.IDomainObject;

public interface IVille extends IDomainObject {

    IUser getJoueur();

    void setJoueur(IUser joueur);
}
