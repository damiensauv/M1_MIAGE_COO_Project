package Persistance.DataMapper;

import Jeu.Interface.IGame;
import Util.UnitOfWork;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GameMapper extends DataMapper<IGame> {


    public IGame find(Integer id) {
        IGame p = idMap.get(id);
        if (p != null) {
            System.out.println("Get From IDMAP");
            return p;
        }

        String req = "SELECT * FROM game WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) { // TODO : LEVER une exception
                System.out.println("not in bd " + id);
                return null;
            }

            p = createGame(rs);
            idMap.put(id, p);
            p.add(UnitOfWork.getInstance());
            return p;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }

    private IGame createGame(ResultSet rs) {
        return null;
    }

    void insert(IGame o) {

    }

    void delete(IGame o) {

    }

    void update(IGame o) throws SQLException {
        String query = "UPDATE coo_tp_personne SET nom=?, prenom=?, id_pere=?, eval=? WHERE id=?"; // revoir la requete
        PreparedStatement preparedStatement = connection.prepareStatement(query);

    /*
        preparedStatement.setString(1, personne.getNom());
    */
        preparedStatement.executeUpdate();
    }
}
