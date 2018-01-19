package Service;

import Domain.Interface.ITerritoire;
import Persistance.DataMapper.TerritoireMapper;

import java.sql.SQLException;

public class TerritoireService {

    private static TerritoireService instance = null;

    public static TerritoireService getInstance() {
        if (instance == null) {
            instance = new TerritoireService();
        }
        return instance;
    }

    private TerritoireService() {

    }

    public void insertBasicTerritoire(ITerritoire t) {
        try {
            TerritoireMapper.getInstance().insert(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
