package Persistance.DataMapper;

import Jeu.Entity.*;
import Jeu.Interface.ITerritoire;
import Jeu.Interface.IUser;
import Jeu.Interface.IVille;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public ITerritoire find(Object id) {
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


    public List<Territoire> findAllTerritoire(Integer id) {

        System.out.println("Territoire Find");
        List<Territoire> p;

        String req = "SELECT * FROM territoire WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) { // TODO : LEVER une exception
                System.out.println("Territoire not in bd " + id);
                return null;
            }

            p = createTerritoire(rs, id);

            return p;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<Territoire> createTerritoire(ResultSet rs, Integer id) throws SQLException {
        int x = 0;
        int y = 0;

        IVille ville = null;
        IUser user = null; // TODO revoir

        List<Territoire> t = new ArrayList<Territoire>();

        while (rs.next()) {
            Type type = Type.valueOf(rs.getString("type"));
            Territoire teriTmp = null;
            ville = null;
            user = null;

            x = rs.getInt("x");
            y = rs.getInt("y");

            if (type.equals(Type.plaine))
                teriTmp = new Plaine(new Coordonnees(x, y), ville, user);
            else if (type.equals(Type.champs))
                teriTmp = new Champ(new Coordonnees(x, y), ville, user);
            else if (type.equals(Type.montagne))
                teriTmp = new Montagne(new Coordonnees(x, y), ville, user);

            t.add(teriTmp);
        }

        return t;
    }
}
