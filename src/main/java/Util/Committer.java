package Util;

import Jeu.Interface.IGame;
import Persistance.DataMapper.GameMapper;

import java.sql.SQLException;

public class Committer extends Visitor {

    public void visiter(IGame o) {
        try {

            GameMapper.getInstance().update(o);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
