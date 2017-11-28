package Jeu.Entity;

import Util.IDomainObject;
import Util.Observer;
import Util.Visitor;

import java.util.ArrayList;
import java.util.List;

public abstract class AObject implements IDomainObject {

    private List<Observer> obs;
    private Integer id;


    AObject() {
        this.obs = new ArrayList<Observer>();
    }

    public void setId(Integer id){
        this.id = id;
        notifier();
    }

    public Integer getId(){
        return this.id;
    }

    public void add(Observer o) {
        obs.add(o);
    }

    public void notifier() {
        for (Observer o : obs)
            o.action(this);
    }

    public void accept(Visitor v) {
        v.visiter(this);
    }
}
