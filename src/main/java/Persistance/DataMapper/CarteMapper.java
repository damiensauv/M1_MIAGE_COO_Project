package Persistance.DataMapper;

import Jeu.Entity.Territoire;
import Jeu.Interface.ICarte;
import Service.TerritoireService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
                System.out.println("Carte not in bd " + id);
                return null;
            }

            p = createCarte(rs);
            idMap.put(id, p);
            return p;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object insert(ICarte o) throws SQLException {
        String query = "INSERT INTO carte(seed) VALUES ('seed')";

        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.executeUpdate();

        Integer idx = getLastIndexInsert(preparedStatement);
        o.setId(idx);

        Territoire[][] carte = o.getCarte();
        for (int i = 0; i < carte.length; i++) {
            for (int j = 0; j < carte[i].length; j++) {
                carte[i][j].setId(idx);
                TerritoireService.getInstance().insertBasicTerritoire(carte[i][j]);
            }
        }
        return 0;
    }

    private ICarte createCarte(ResultSet rs) {
        return null;
    }

    public void delete(ICarte o) {

    }

    public void update(ICarte o) throws SQLException {

    }

}
