package Util;

public abstract class Visitor<T>{

    public void visiter(IDomainObject o){
        o.accept(this);
    }
}