package Persistance.DataMapper;

import Jeu.Entity.Joueur;
import Jeu.Interface.IGame;
import Jeu.Interface.IJoueur;
import Jeu.Interface.IUser;
import Persistance.Factory.GameFactory;
import Persistance.Factory.UserFactory;
import Util.UnitOfWork;
import Util.VirtualProxyGenerique;
import javafx.util.Pair;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        IJoueur joueur = new Joueur();

        joueur.setGame(new VirtualProxyGenerique.VirtualProxyBuilder<IGame>(IGame.class, new GameFactory(rs.getInt("id_game"))).getProxy());
        joueur.setUser(new VirtualProxyGenerique.VirtualProxyBuilder<IUser>(IUser.class, new UserFactory(rs.getInt("id_user"))).getProxy());

        return joueur;
    }


    public IJoueur find(Object idx) {

        Pair<Integer, Integer> id = (Pair<Integer, Integer>) idx;

        System.out.println("FIND JOUEUR");

        IJoueur p = idMap.get(id);
        if (p != null) {
            System.out.println("Get From IDMAP");
            return p;
        }

        String req = "SELECT * FROM joueur WHERE id_user=? AND id_game=?";
        try {
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id.getKey());
            ps.setInt(2, id.getValue());
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) { // TODO : LEVER une exception
                System.out.println("not in bd " + id);
                return null;
            }

            p = createJoueur(rs);
            idMap.put(id, p);
            p.add(UnitOfWork.getInstance());
            return p;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object insert(IJoueur o) throws SQLException {

        String query = "INSERT INTO joueur(id_user, id_game) VALUES (?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, o.getUser().getId());
        preparedStatement.setInt(2, o.getGame().getId());
        preparedStatement.executeUpdate();

        Pair<Integer, Integer> idx = new Pair<Integer, Integer>(o.getUser().getId(), o.getGame().getId());

        idMap.put(idx, o);
        o.add(UnitOfWork.getInstance());
        return idx;
    }

    void delete(IJoueur o) {

    }

    void update(IJoueur o) throws SQLException {

        System.out.println("UPDATE Joueur");

    }


}
