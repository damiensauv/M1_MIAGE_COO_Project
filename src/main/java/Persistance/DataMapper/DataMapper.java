package Persistance.DataMapper;

import Persistance.MySql.MySql;
import Util.IDMap;

import java.sql.Connection;

public abstract class DataMapper<T> {

    protected Connection connection;
    protected IDMap<T> idMap;

    public DataMapper() {
        try {
            connection = MySql.getInstance();
            idMap = new IDMap<T>();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    abstract T find(Integer id);

    abstract void insert(T o);

    abstract void delete(T o);

    abstract void update(T o);
}
