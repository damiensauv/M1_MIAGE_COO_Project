package Util;

import Jeu.Interface.IGame;
import Jeu.Interface.ITerritoire;
import Persistance.DataMapper.GameMapper;
import Persistance.DataMapper.TerritoireMapper;

import java.sql.SQLException;

public class Committer extends Visitor {

    public void visiter(IGame o) {
        try {

            GameMapper.getInstance().update(o);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void visiter(ITerritoire o) {
        try {

            TerritoireMapper.getInstance().update(o);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
