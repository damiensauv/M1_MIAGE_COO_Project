package Persistance.Factory;

import Domain.Interface.IJoueur;
import Persistance.DataMapper.JoueurMapper;

import java.util.List;

public class ListUserInGameFactory implements Factory<List<IJoueur>> {

    private int id;

    public ListUserInGameFactory(int id) {
        this.id = id;
    }

    public List<IJoueur> create() {
        return JoueurMapper.getInstance().findAllJoueurInGame(this.id);
    }
}
