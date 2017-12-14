package Persistance.DataMapper;

import Persistance.MySql.MySql;
import Util.IDMap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    abstract T find(Object id);

    abstract Object insert(T o) throws SQLException;

    abstract void delete(T o);

    abstract void update(T o) throws SQLException;

    public Integer getLastIndexInsert(PreparedStatement ps) {
        try {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return 0;
    }
}
