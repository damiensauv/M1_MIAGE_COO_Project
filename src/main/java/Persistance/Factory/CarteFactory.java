package Persistance.Factory;

import Jeu.Interface.ICarte;
import Persistance.DataMapper.CarteMapper;

public class CarteFactory implements Factory<ICarte> {

    private Integer id;

    public CarteFactory(Integer id) {
        this.id = id;
    }

    public ICarte create() {
        ICarte carte = CarteMapper.getInstance().find(this.id);
        return carte;
    }

}
