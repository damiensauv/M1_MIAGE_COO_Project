package Service;

import Jeu.Entity.Carte;
import Jeu.Entity.Coordonnees;
import Jeu.Entity.Ville;
import Jeu.Interface.ICarte;
import Jeu.Interface.IGame;
import Jeu.Interface.IJoueur;
import Jeu.Interface.IVille;
import Persistance.DataMapper.CarteMapper;
import Util.UnitOfWork;

import java.sql.SQLException;
import java.util.Random;

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

    public void initVille(ICarte carte, IGame game) {
        int randomX;
        int randomY;
        boolean flag;

        Random randomGenerator = new Random();

        for (IJoueur j : game.getUserInGame()) {
            // TODO : prendre en compte la distance Min
            flag = true;
            IVille ville = new Ville(j.getUser());
            while (flag) {
                randomX = randomGenerator.nextInt(game.getMapSize().getX());
                randomY = randomGenerator.nextInt(game.getMapSize().getY());


            }
        }


        UnitOfWork.getInstance().commit();
    }
}
