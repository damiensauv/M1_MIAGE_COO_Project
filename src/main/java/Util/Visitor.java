package Util;

import Jeu.Interface.IGame;
import Jeu.Interface.IJoueur;
import Jeu.Interface.ITerritoire;
import Jeu.Interface.IUser;

public abstract class Visitor<T>{

    public void visiter(IDomainObject o){
        o.accept(this);
    }

    abstract public void visiter(IGame o);

    abstract public void visiter(ITerritoire o);

    abstract public void visiter(IJoueur o);

    abstract public void visiter(IUser o);
}