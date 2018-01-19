package Persistance.Factory;

import Domain.Interface.IJoueur;
import Persistance.DataMapper.JoueurMapper;


public class JoueurFactory implements Factory<IJoueur> {

    private Integer[] id;

    public JoueurFactory(Integer[] id) {
        this.id = id;
    }

    public IJoueur create() {
        IJoueur joueur = JoueurMapper.getInstance().find(this.id);
        return joueur;
    }

}
