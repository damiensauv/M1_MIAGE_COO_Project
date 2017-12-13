package Persistance.Factory;

import Jeu.Interface.IJoueur;
import Persistance.DataMapper.JoueurMapper;
import javafx.util.Pair;

public class JoueurFactory implements Factory<IJoueur> {

    private Pair<Integer, Integer> id;

    public JoueurFactory(Pair<Integer, Integer> id) {
        this.id = id;
    }

    public IJoueur create() {
        IJoueur joueur = JoueurMapper.getInstance().find(this.id);
        return joueur;
    }

}
