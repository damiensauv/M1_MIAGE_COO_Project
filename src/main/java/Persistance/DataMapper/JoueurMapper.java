package Persistance.DataMapper;

import Jeu.Interface.IGame;
import Jeu.Interface.IJoueur;
import Util.UnitOfWork;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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


    public IJoueur find(Integer id) {
        return null;
    }

    public void insert(IJoueur o) throws SQLException {

        String query = "INSERT INTO joueur(id_user, id_game) VALUES (?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, o.getUser().getId());
        preparedStatement.setInt(2, o.getGame().getId());
        preparedStatement.executeUpdate();

        Integer idx = getLastIndexInsert(preparedStatement);

        idMap.put(idx, o);
        o.add(UnitOfWork.getInstance());
    }

    void delete(IJoueur o) {

    }

    void update(IJoueur o) throws SQLException {

    }

    public IJoueur findByGameAndUser(Integer id_game, Integer id_user) {


    }
}
