package Persistance.DataMapper;

import Jeu.Entity.Carte;
import Jeu.Entity.Territoire;
import Jeu.Interface.ICarte;
import Persistance.Factory.TerritoireFactory;
import Service.TerritoireService;
import Util.VirtualProxyGenerique;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

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

        System.out.println("CArte Find");

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

        List<List<Territoire>> carte = o.getTerritoires();

        for (List<Territoire> at : carte) {
            for (Territoire t : at) {
                t.setId(idx);
                TerritoireService.getInstance().insertBasicTerritoire(t);
            }
        }

        return 0;
    }

    private ICarte createCarte(ResultSet rs) throws SQLException {

        ICarte carte = new Carte(
                rs.getInt("id"),
                rs.getString("seed"),
                new VirtualProxyGenerique.VirtualProxyBuilder<List<List<Territoire>>>(List.class, new TerritoireFactory(rs.getInt("id"))).getProxy()
        );

        return carte;
    }

    public void delete(ICarte o) {

    }

    public void update(ICarte o) throws SQLException {

    }

}
