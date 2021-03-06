package Persistance.DataMapper;

import Domain.Entity.Joueur;
import Domain.Interface.IGame;
import Domain.Interface.IJoueur;
import Domain.Interface.IUser;
import Persistance.Factory.GameFactory;
import Persistance.Factory.UserFactory;
import Util.VirtualProxyGenerique;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class JoueurMapper extends DataMapper<IJoueur> {

    private static JoueurMapper instance = null;

    public static JoueurMapper getInstance() {
        if (instance == null) {
            instance = new JoueurMapper();
        }
        return instance;
    }

    private JoueurMapper() {
    }

    private IJoueur createJoueur(ResultSet rs) throws SQLException {

        return new Joueur(
                new VirtualProxyGenerique.VirtualProxyBuilder<IGame>(IGame.class, new GameFactory(rs.getInt("id_game"))).getProxy(),
                new VirtualProxyGenerique.VirtualProxyBuilder<IUser>(IUser.class, new UserFactory(rs.getInt("id_user"))).getProxy(),
                rs.getInt("ressource")
        );
    }


    public IJoueur find(Object idx) {

        Integer[] id = (Integer[]) idx;

        IJoueur p = idMap.get(id);
        if (p != null) {
            System.out.println("Get From IDMAP");
            return p;
        }

        String req = "SELECT * FROM joueur WHERE id_user=? AND id_game=?";
        try {
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id[0]);
            ps.setInt(2, id[1]);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("not in bd " + id);
                return null;
            }

            p = createJoueur(rs);
            idMap.put(id, p);

            return p;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object insert(IJoueur o) throws SQLException {

        String query = "INSERT INTO joueur(id_user, id_game, ressource) VALUES (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, o.getUser().getId());
        preparedStatement.setInt(2, o.getGame().getId());
        preparedStatement.setInt(3, o.getRessource());
        preparedStatement.executeUpdate();

        Integer[] idx = new Integer[2];
        idx[0] = o.getUser().getId();
        idx[1] = o.getGame().getId();
        idMap.put(idx, o);
        return idx;
    }

    void delete(IJoueur o) {

    }

    public void update(IJoueur o) throws SQLException {

        System.out.println("Update Joueur");

        String query = "UPDATE joueur SET ressource=? WHERE id_user=? AND id_game=?";
        PreparedStatement ps = connection.prepareStatement(query);

        ps.setInt(1, o.getRessource());
        ps.setInt(2, o.getUser().getId());
        ps.setInt(3, o.getGame().getId());
        ps.executeUpdate();
    }

    public List<IJoueur> findAllJoueurInGame(int id) {
        String req = "SELECT * FROM joueur WHERE id_game=?";
        try {
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Joueur not in bd " + id);
                return new ArrayList<IJoueur>();
            }

            List<IJoueur> lists = new ArrayList<IJoueur>();
            do {
                IJoueur g = createJoueur(rs);
                lists.add(g);
            } while (rs.next());

            return lists;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean isUserInGame(int id_game, int id_user) {
        String req = "SELECT * FROM joueur WHERE id_game=? AND id_user=?";

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(req);
            ps.setInt(1, id_game);
            ps.setInt(2, id_user);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("not in bd");
                return false;
            }
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
}
