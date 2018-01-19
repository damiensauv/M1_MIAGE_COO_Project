package Persistance.DataMapper;

import Domain.Entity.*;
import Domain.Interface.ITerritoire;
import Domain.Interface.IUser;
import Domain.Interface.IVille;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
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

        String query = "UPDATE territoire SET id_ville=?, owner=? WHERE id=? AND x=? AND y=?";
        PreparedStatement ps = connection.prepareStatement(query);

        IVille v = o.getVilles();
        IUser u = o.getOwner();

        if (v.getId() == null)
            ps.setNull(1, Types.INTEGER);
        else
            ps.setInt(1, v.getId());

        if (u == null)
            ps.setNull(2, Types.INTEGER);
        else
            ps.setInt(2, u.getId());

        ps.setInt(3, o.getId());
        ps.setInt(4, o.getCoordonnees().getX());
        ps.setInt(5, o.getCoordonnees().getY());


        ps.executeUpdate();

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
        int idx;

        IVille ville = null;
        IUser user = null; // TODO revoir

        List<Territoire> t = new ArrayList<Territoire>();

        while (rs.next()) {
            Type type = Type.valueOf(rs.getString("type"));
            Territoire teriTmp = null;
            ville = null;
            user = null;
            idx = rs.getInt("id");

            x = rs.getInt("x");
            y = rs.getInt("y");

            if (type.equals(Type.plaine))
                teriTmp = new Plaine(new Coordonnees(x, y), ville, user, idx);
            else if (type.equals(Type.champs))
                teriTmp = new Champ(new Coordonnees(x, y), ville, user, idx);
            else if (type.equals(Type.montagne))
                teriTmp = new Montagne(new Coordonnees(x, y), ville, user, idx);

            t.add(teriTmp);
        }

        return t;
    }
}
