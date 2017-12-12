package Service;

import Jeu.Entity.Coordonnees;
import Jeu.Entity.Game;
import Jeu.Interface.IGame;
import Persistance.DataMapper.GameMapper;
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
        game.setStatus(false);
        game.setOwner(null); // a changer
        game.setMapSize(coordonnees);
        game.setMaxUser(maxUser);
        game.setNbInitRes(nbInitRes);
        game.setTimeTurn(timeTurn);
        game.setNbResTurn(nbResTurn);
        game.setCarte(null); // A changer

        GameMapper.getInstance().insert(game);
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

    public List<Game> getAwaytingGame() {
        return null;
    }

}
