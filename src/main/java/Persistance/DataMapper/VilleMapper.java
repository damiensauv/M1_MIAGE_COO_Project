package Persistance.DataMapper;

import Jeu.Interface.IVille;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class VilleMapper extends DataMapper<IVille> {

    private static VilleMapper instance = null;

    public static VilleMapper getInstance() {
        if (instance == null) {
            instance = new VilleMapper();
        }
        return instance;
    }

    private VilleMapper() {
    }

    @Override
    IVille find(Object id) {
        return null;
    }


    public IVille insert(IVille o) throws SQLException {
        String query = "INSERT INTO ville(id_joueur, id_carte) VALUES (?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, o.getJoueur().getId());
        preparedStatement.setInt(2, o.getCarte().getId());

        preparedStatement.executeUpdate();

        Integer idx = getLastIndexInsert(preparedStatement);
        o.setId(idx);

        return o;
    }

    @Override
    void delete(IVille o) {

    }

    @Override
    void update(IVille o) throws SQLException {

    }
}
