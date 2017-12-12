package Util;

import java.util.HashSet;
import java.util.Set;

public class UnitOfWork implements Observer {

    private static UnitOfWork inst = null;
    public Set<IDomainObject> dirty;

    public static UnitOfWork getInstance() {
        if (inst == null) {
            inst = new UnitOfWork();
        }
        return inst;
    }

    private UnitOfWork() {
        dirty = new HashSet<IDomainObject>();
    }

    public void action(IDomainObject obj) {
        dirty.add(obj);
    }

    public void commit() {
        Visitor v = new Committer();

        for (IDomainObject obj : dirty) {
            v.visiter(obj);
        }

        dirty.clear();
    }


}