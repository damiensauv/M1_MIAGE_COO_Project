package Service;

import Jeu.Entity.Coordonnees;
import Jeu.Entity.Game;
import Jeu.Entity.Status;
import Jeu.Interface.IGame;
import Jeu.Interface.IJoueur;
import Jeu.Interface.IUser;
import Persistance.DataMapper.GameMapper;
import Persistance.DataMapper.JoueurMapper;
import Util.UnitOfWork;

import java.sql.SQLException;
import java.util.List;


public class GameService {

    private static GameService instance = null;

    public static GameService getInstance() {
        if (instance == null) {
            instance = new GameService();
        }
        return instance;
    }

    private GameService() {

    }

    public void createGame(Coordonnees coordonnees, Integer maxUser, Integer nbInitRes, Integer nbResTurn, Integer timeTurn, String name) throws SQLException {

        IGame game = new Game();

        game.setName(name);
        game.setStatus(Status.awayting);
        game.setOwner(UserService.getInstance().getConnectedUser());
        game.setMapSize(coordonnees);
        game.setMaxUser(maxUser);
        game.setNbInitRes(nbInitRes);
        game.setTimeTurn(timeTurn);
        game.setNbResTurn(nbResTurn);

        Integer idx = GameMapper.getInstance().insert(game);

        game.setCarte(CarteService.getInstance().createCarte(coordonnees, idx));

        System.out.println("Count " + game.getUserInGame().size());

        UnitOfWork.getInstance().commit();
    }

    public void updateGame(Game game) {

    }

    public Game getGame(Integer id) {
        return null;
    }

    public List<Game> getActiveGameOfPlayer(Integer idUser) {
        return null;
    }

    public List<IGame> getAwaytingGame() {
        return GameMapper.getInstance().findAllGamesByStatus();
    }


    public boolean isUserInGame(int id_game, int id_user) {
        return JoueurMapper.getInstance().isUserInGame(id_game, id_user);
    }

    public Integer addCurrentJoueur(IGame game) {
        IUser u = UserService.getInstance().getConnectedUser();

        // le joueur est deja dans la game
        if (this.isUserInGame(game.getId(), u.getId())) {
            return 1;
        } else if (game.getUserInGame().size() == game.getMaxUser()) {
            return 2;
        } else {
            try {
                IJoueur j = JoueurService.getInstance().createJoueur(game, u);
                game.addUserInGame(j);
                UnitOfWork.getInstance().commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return 0;
    }

    public Integer launchGame(IGame game) {
        IUser u = UserService.getInstance().getConnectedUser();

        if (game.getOwner() != u)
            return 1;

        if (game.getUserInGame().size() <= 1)
            return 2;

        // gene

        return 0;
    }
}
