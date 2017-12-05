package Service;

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

    public void createGame(){

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
