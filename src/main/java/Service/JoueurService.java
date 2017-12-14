package Service;

import Jeu.Entity.Joueur;
import Jeu.Interface.IGame;
import Jeu.Interface.IUser;
import Persistance.DataMapper.JoueurMapper;

import java.sql.SQLException;

public class JoueurService {

    private static JoueurService instance = null;

    public static JoueurService getInstance() {
        if (instance == null) {
            instance = new JoueurService();
        }
        return instance;
    }

    private JoueurService() {

    }

    public void createJoueur(IGame game, IUser user) throws SQLException {

        Joueur joueur = new Joueur();
        joueur.setGame(game);
        joueur.setUser(user);

        JoueurMapper.getInstance().insert(joueur);
    }


}