package Persistance.DataMapper;

import Jeu.Entity.Coordonnees;
import Jeu.Entity.Game;
import Jeu.Entity.Status;
import Jeu.Interface.ICarte;
import Jeu.Interface.IGame;
import Jeu.Interface.IJoueur;
import Jeu.Interface.IUser;
import Persistance.Factory.CarteFactory;
import Persistance.Factory.ListUserInGameFactory;
import Persistance.Factory.UserFactory;
import Util.UnitOfWork;
import Util.VirtualProxyGenerique.VirtualProxyBuilder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
            System.out.println("Get From IDMAP Game");
            return p;
        }

        String req = "SELECT * FROM game WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) { // TODO : LEVER une exception
                System.out.println("Game not in bd " + id);
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

        Integer x = rs.getInt("map_size_x");
        Integer y = rs.getInt("map_size_y");

        IGame game = new Game(
                rs.getInt("id"),
                rs.getString("name"),
                Status.valueOf(rs.getString("status")),
                new VirtualProxyBuilder<IUser>(IUser.class, new UserFactory(rs.getInt("owner"))).getProxy(),
                new VirtualProxyBuilder<IUser>(IUser.class, new UserFactory(rs.getInt("winner"))).getProxy(),
                new Coordonnees(x, y),
                rs.getInt("max_user"),
                rs.getInt("nb_init_res"),
                rs.getInt("nb_res_turn"),
                rs.getInt("time_turn"),
                rs.getInt("distance_min_ville"),
                new VirtualProxyBuilder<ICarte>(ICarte.class, new CarteFactory(rs.getInt("carte"))).getProxy(),
                rs.getInt("current_turn"),
                new VirtualProxyBuilder<List<IJoueur>>(List.class, new ListUserInGameFactory(rs.getInt("id"))).getProxy()
        );

        return game;
    }

    public Integer insert(IGame o) throws SQLException { // passer avec un try catch ici

        String query = "INSERT INTO game(name, owner, map_size_x, map_size_y, max_user, nb_init_res, nb_res_turn, time_turn, status, distance_min_ville, carte)" +
                " VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, o.getName());
        preparedStatement.setInt(2, o.getOwner().getId());
        preparedStatement.setInt(3, o.getMapSize().getX());
        preparedStatement.setInt(4, o.getMapSize().getY());
        preparedStatement.setInt(5, o.getMaxUser());
        preparedStatement.setInt(6, o.getNbInitRes());
        preparedStatement.setInt(7, o.getNbResTurn());
        preparedStatement.setInt(8, o.getTimeTurn());
        preparedStatement.setString(9, o.getStatus().toString());
        preparedStatement.setInt(10, o.getDistanceMinVille());
        preparedStatement.setInt(11, o.getCarte().getId());
        preparedStatement.executeUpdate();

        return this.getLastIndexInsert(preparedStatement);
    }

    public void delete(IGame o) {

    }

    public void update(IGame o) throws SQLException {

        System.out.println("UPDATE GAME");

        String query = "UPDATE game SET  current_turn=?, status=? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(query);

        // TODO : UPDATE WINNER
        ps.setInt(1, o.getCurrentTurn());
        ps.setString(2, o.getStatus().toString());
        ps.setInt(3, o.getId());
        ps.executeUpdate();
    }

    public List<IGame> findAllGamesByStatus() {

        List<IGame> listGames = new ArrayList<IGame>();
        String req = "SELECT * FROM game WHERE status = 'awayting'";
        try {
            PreparedStatement ps = connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) { // TODO : LEVER une exception
                System.out.println("Game not in bd ");
                return null;
            }

            do {
                IGame g = createGame(rs);
                listGames.add(g);
            } while (rs.next());
            return listGames;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
