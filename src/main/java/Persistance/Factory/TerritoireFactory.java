package Persistance.Factory;

import Jeu.Entity.Territoire;
import Persistance.DataMapper.TerritoireMapper;

import java.util.List;

public class TerritoireFactory implements Factory<List<List<Territoire>>> {

    private Integer id;

    public TerritoireFactory(int id) {
        this.id = id;
    }

    public List<List<Territoire>> create() {
        return TerritoireMapper.getInstance().findAllTerritoire(this.id);
    }
}
