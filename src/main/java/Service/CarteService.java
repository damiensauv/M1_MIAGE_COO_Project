package Service;

import Jeu.Entity.Carte;
import Jeu.Entity.Coordonnees;
import Persistance.DataMapper.CarteMapper;
import Util.UnitOfWork;

import java.sql.SQLException;

public class CarteService {

    private static CarteService instance = null;

    public static CarteService getInstance() {
        if (instance == null) {
            instance = new CarteService();
        }
        return instance;
    }

    private CarteService() {

    }

    public Carte createCarte(Coordonnees coordonnees, Integer idx) {

        Carte carte = new Carte(coordonnees);

        try {
            CarteMapper.getInstance().insert(carte, idx);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        UnitOfWork.getInstance().commit();
        return carte;
    }
}
