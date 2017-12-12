package Util;

import Jeu.Interface.IGame;

public abstract class Visitor<T>{

    public void visiter(IDomainObject o){
        o.accept(this);
    }

    abstract public void visiter(IGame o);
}