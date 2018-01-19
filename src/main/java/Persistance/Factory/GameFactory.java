package Persistance.Factory;

import Domain.Interface.IGame;
import Persistance.DataMapper.GameMapper;

public class GameFactory implements Factory<IGame> {

    private Integer id;

    public GameFactory(Integer id) {
        this.id = id;
    }

    public IGame create() {
        IGame game = GameMapper.getInstance().find(this.id);
        return game;
    }
}
