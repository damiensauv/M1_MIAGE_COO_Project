package Util;

import Jeu.Interface.IGame;
import Jeu.Interface.IJoueur;
import Jeu.Interface.ITerritoire;
import Jeu.Interface.IUser;
import Persistance.DataMapper.GameMapper;
import Persistance.DataMapper.JoueurMapper;
import Persistance.DataMapper.TerritoireMapper;
import Persistance.DataMapper.UserMapper;

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

    public void visiter(IJoueur o) {
        try {

            JoueurMapper.getInstance().update(o);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void visiter(IUser o) {

        UserMapper.getInstance().update(o);

    }
}
