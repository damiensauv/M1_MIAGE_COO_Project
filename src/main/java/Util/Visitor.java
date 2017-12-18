package Util;

import Jeu.Interface.IGame;
import Jeu.Interface.ITerritoire;

public abstract class Visitor<T>{

    public void visiter(IDomainObject o){
        o.accept(this);
    }

    abstract public void visiter(IGame o);

    abstract public void visiter(ITerritoire o);
}