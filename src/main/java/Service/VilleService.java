package Service;

import Jeu.Interface.IVille;
import Persistance.DataMapper.VilleMapper;

import java.sql.SQLException;

public class VilleService {

    private static VilleService instance = null;


    public static VilleService getInstance() {
        if (instance == null) {
            instance = new VilleService();
        }
        return instance;
    }

    private VilleService() {
    }

    public IVille createVille(IVille ville) {
        try {
            return VilleMapper.getInstance().insert(ville);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
