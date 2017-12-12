package Service;

import Jeu.Entity.Coordonnees;
import Jeu.Entity.Game;

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

    public void createGame(Coordonnees co, Integer maxu, Integer nbir, Integer nbRest, Integer tt, String name){






    }

    public void updateGame(Game game){

    }

    public Game getGame(Integer id){

        return null;
    }

    public List<Game> getActiveGameOfPlayer(Integer idUser){
        return null;
    }

    public List<Game> getAwaytingGame(){
        return null;
    }

}
