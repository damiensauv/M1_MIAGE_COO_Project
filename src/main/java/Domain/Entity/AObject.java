package Domain.Entity;

import Util.IDomainObject;
import Util.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class AObject implements IDomainObject {

    protected List<Observer> obs;
    private Integer id;

    AObject() {
        this.obs = new ArrayList<Observer>();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

}
