package Persistance.DataMapper;

import Jeu.Interface.ITerritoire;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TerritoireMapper extends DataMapper<ITerritoire> {

    private static TerritoireMapper instance = null;

    public static TerritoireMapper getInstance() {
        if (instance == null) {
            instance = new TerritoireMapper();
        }
        return instance;
    }

    private TerritoireMapper() {
    }

    ITerritoire find(Object id) {
        return null;
    }

    public Object insert(ITerritoire o) throws SQLException {
        String query = "INSERT INTO territoire(id, x, y, type) VALUES (?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, o.getId());
        preparedStatement.setInt(2, o.getCoordonnees().getX());
        preparedStatement.setInt(3, o.getCoordonnees().getY());
        preparedStatement.setString(4, o.getType().toString());
        preparedStatement.executeUpdate();
        return 0;
    }

    void delete(ITerritoire o) {

    }

    public void update(ITerritoire o) throws SQLException {
        System.out.println("UPDATE TERRITOIRE");
    }


}
