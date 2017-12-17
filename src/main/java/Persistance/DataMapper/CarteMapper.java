package Persistance.DataMapper;

import Jeu.Entity.Territoire;
import Jeu.Interface.ICarte;
import Util.UnitOfWork;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarteMapper extends DataMapper<ICarte> {

    private static CarteMapper instance = null;

    public static CarteMapper getInstance() {
        if (instance == null) {
            instance = new CarteMapper();
        }
        return instance;
    }

    private CarteMapper() {
    }

    public ICarte find(Object idx) {

        Integer id = (Integer) idx;

        ICarte p = idMap.get(id);
        if (p != null) {
            System.out.println("Get From IDMAP");
            return p;
        }

        String req = "SELECT * FROM carte WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) { // TODO : LEVER une exception
                System.out.println("not in bd " + id);
                return null;
            }

            p = createCarte(rs);
            idMap.put(id, p);
            p.add(UnitOfWork.getInstance());
            return p;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    Object insert(ICarte o) throws SQLException {
        return null;
    }

    private ICarte createCarte(ResultSet rs) {
        return null;
    }

    public Integer insert(ICarte o, Integer idx_game) throws SQLException { // passer avec un try catch ici
        String query = "INSERT INTO carte(id, x, y, type)" +
                " VALUES (?,?,?,?)";

        Territoire[][] carte = o.getCarte();
        for (int i = 0; i < carte.length; i++) {
            for (int j = 0; j < carte[i].length; j++) {

                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, idx_game);
                preparedStatement.setInt(2, i);
                preparedStatement.setInt(3, j);
                preparedStatement.setString(4, carte[i][j].getType().toString());
                preparedStatement.executeUpdate();
            }
        }

        return 0;
    }



    public void delete(ICarte o) {

    }

    public void update(ICarte o) throws SQLException {

    }

}
