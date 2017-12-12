package Persistance.DataMapper;

import Jeu.Interface.IJoueur;

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


    IJoueur find(Integer id) {
        return null;
    }

    void insert(IJoueur o) throws SQLException {

    }

    void delete(IJoueur o) {

    }

    void update(IJoueur o) throws SQLException {

    }
}
