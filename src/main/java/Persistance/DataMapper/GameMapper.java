package Persistance.DataMapper;

import Jeu.Entity.Coordonnees;
import Jeu.Entity.Game;
import Jeu.Entity.Joueur;
import Jeu.Entity.Status;
import Jeu.Interface.ICarte;
import Jeu.Interface.IGame;
import Jeu.Interface.IJoueur;
import Jeu.Interface.IUser;
import Persistance.Factory.CarteFactory;
import Persistance.Factory.JoueurFactory;
import Persistance.Factory.ListUserInGameFactory;
import Persistance.Factory.UserFactory;
import Util.UnitOfWork;
import Util.VirtualProxyGenerique.VirtualProxyBuilder;

import java.sql.*;
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
        game.setCarte(new VirtualProxyBuilder<ICarte>(ICarte.class, new CarteFactory(rs.getInt("carte"))).getProxy());
        game.setCurrentTurn(rs.getInt("current_turn"));
        game.setStatus(Status.valueOf(rs.getString("status")));
        game.setUserInGame(new VirtualProxyBuilder<List<IJoueur>>(List.class, new ListUserInGameFactory(rs.getInt("id"))).getProxy());

        return game;
    }

    public Integer insert(IGame o) throws SQLException { // passer avec un try catch ici

        String query = "INSERT INTO game(name, owner, map_size_x, map_size_y, max_user, nb_init_res, nb_res_turn, time_turn, status)" +
                " VALUES (?,?,?,?,?,?,?,?,?)";

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

        preparedStatement.executeUpdate();

        Integer idx = getLastIndexInsert(preparedStatement);

        o.setId(idx);

        IJoueur joueur = new Joueur(o.getOwner(), o);

        Integer[] idxJoueur = (Integer[]) JoueurMapper.getInstance().insert(joueur);

        o.addUserInGame(new VirtualProxyBuilder<IJoueur>(IJoueur.class, new JoueurFactory(idxJoueur)).getProxy());

        idMap.put(idx, o);
        o.add(UnitOfWork.getInstance());
        return idx;
    }

    public void delete(IGame o) {

    }

    public void update(IGame o) throws SQLException {
        String query = "UPDATE game SET winner=?, current_turn=?, status=?, carte=? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(query);

        System.out.println("UPDATE GAME : " + o.getId());

        if (o.getWinner() == null)
            ps.setNull(1, Types.NULL);
        else
            ps.setInt(1, o.getWinner().getId());

        ps.setInt(2, o.getCurrentTurn());
        ps.setString(3, o.getStatus().toString());
        ps.setInt(4, o.getId());
        ps.setInt(5, o.getId());
        ps.executeUpdate();
    }

    public List<IGame> findAllGamesByStatusAndPlaceFree() {

        List<IGame> listGames = new ArrayList<IGame>();
        String req = "SELECT * FROM game WHERE status = 'awayting'";

        try {
            PreparedStatement ps = connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) { // TODO : LEVER une exception
                System.out.println("not in bd ");
                return null;
            }

            while (rs.next()) {
                IGame g = createGame(rs);
                IGame p = idMap.get(g.getId());
                if (p == null) {
                    idMap.put(g.getId(), g);
                    g.add(UnitOfWork.getInstance());
                }
                listGames.add(g);
            }

            return listGames;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
