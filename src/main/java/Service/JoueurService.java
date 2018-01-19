package Service;

import Domain.Entity.Joueur;
import Domain.Interface.IGame;
import Domain.Interface.IJoueur;
import Domain.Interface.IUser;
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

    public IJoueur createJoueur(IGame game, IUser user) throws SQLException {

        IJoueur joueur = new Joueur(user, game);

        JoueurMapper.getInstance().insert(joueur);
        return joueur;
    }


}
