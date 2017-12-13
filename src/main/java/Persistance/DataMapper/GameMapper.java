package Persistance.DataMapper;

import Jeu.Entity.*;
import Jeu.Interface.IGame;
import Jeu.Interface.IJoueur;
import Jeu.Interface.IUser;
import Persistance.Factory.JoueurFactory;
import Persistance.Factory.UserFactory;
import Util.UnitOfWork;
import Util.VirtualProxyGenerique.VirtualProxyBuilder;
import javafx.util.Pair;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GameMapper extends DataMapper<IGame> {

    private static GameMapper instance = null;

    public static GameMapper getInstance() {
        if (instance == null) {
            instance = new GameMapper();
        }
        return instance;
    }

    private GameMapper() {
    }

    public IGame find(Object idx) {

        Integer id = (Integer) idx;

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

    private IGame createGame(ResultSet rs) throws SQLException {
        IGame game = new Game();

        game.setId(rs.getInt("id"));
        game.setName(rs.getString("name"));
        game.setOwner(new VirtualProxyBuilder<IUser>(IUser.class, new UserFactory(rs.getInt("owner"))).getProxy());
        game.setWinner(new VirtualProxyBuilder<IUser>(IUser.class, new UserFactory(rs.getInt("winner"))).getProxy());
        Integer x = rs.getInt("map_size_x");
        Integer y = rs.getInt("map_size_y");
        game.setMapSize(new Coordonnees(x, y));
        game.setMaxUser(rs.getInt("max_user"));
        game.setNbInitRes(rs.getInt("nb_init_res"));
        game.setNbResTurn(rs.getInt("nb_res_turn"));
        game.setTimeTurn(rs.getInt("time_turn"));
        game.setCarte(new Carte(1, 1)); // TODO : A REvoir
        game.setCurrentTurn(rs.getInt("current_turn"));
        game.setStatus(Status.valueOf(rs.getString("status")));

//        game.setUserInGame(); // recup Dans joueur by Game la liste des Joueur, Proxy, Factory!!

        return game;
    }

    public Integer insert(IGame o) throws SQLException { // passer avec un try catch ici

        String query = "INSERT INTO game(name, owner, map_size_x, map_size_y, max_user, nb_init_res, nb_res_turn, time_turn, carte, status)" +
                " VALUES (?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, o.getName());
        preparedStatement.setInt(2, o.getOwner().getId());
        preparedStatement.setInt(3, o.getMapSize().getX());
        preparedStatement.setInt(4, o.getMapSize().getY());
        preparedStatement.setInt(5, o.getMaxUser());
        preparedStatement.setInt(6, o.getNbInitRes());
        preparedStatement.setInt(7, o.getNbResTurn());
        preparedStatement.setInt(8, o.getTimeTurn());
        preparedStatement.setInt(9, 1); // a changer !!
        preparedStatement.setString(10, o.getStatus().toString());

        preparedStatement.executeUpdate();

        Integer idx = getLastIndexInsert(preparedStatement);

        o.setId(idx);

        IJoueur joueur = new Joueur(o.getOwner(), o);

        Pair<Integer, Integer> idxJoueur = (Pair<Integer, Integer>) JoueurMapper.getInstance().insert(joueur);

        o.addUserInGame(new VirtualProxyBuilder<IJoueur>(IJoueur.class, new JoueurFactory(idxJoueur)).getProxy());


        idMap.put(idx, o);
        o.add(UnitOfWork.getInstance());
        return idx;
    }

    public void delete(IGame o) {

    }

    public void update(IGame o) throws SQLException {
        String query = "UPDATE game SET winner=?, current_turn=?, status=? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(query);

        ps.setInt(1, o.getWinner().getId());
        ps.setInt(2, o.getCurrentTurn());
        ps.setString(3, o.getStatus().toString());
        ps.setInt(4, o.getOwner().getId());

    }
}
