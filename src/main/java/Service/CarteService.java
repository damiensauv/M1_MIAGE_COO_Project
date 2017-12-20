package Service;

import Jeu.Entity.Carte;
import Jeu.Entity.Coordonnees;
import Jeu.Entity.Territoire;
import Jeu.Entity.Ville;
import Jeu.Interface.ICarte;
import Jeu.Interface.IGame;
import Jeu.Interface.IJoueur;
import Jeu.Interface.IVille;
import Persistance.DataMapper.CarteMapper;
import Util.UnitOfWork;

import java.sql.SQLException;
import java.util.List;
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

    public Carte createCarte(Coordonnees coordonnees) {

        Carte carte = new Carte(coordonnees);

        try {
            CarteMapper.getInstance().insert(carte);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        UnitOfWork.getInstance().commit();
        return carte;
    }

    public void initVille(IGame game) {
        int randomX;
        int randomY;
        boolean flag;

        Random randomGenerator = new Random();

        ICarte carte = game.getCarte();

        for (IJoueur j : game.getUserInGame()) {
            // TODO : prendre en compte la distance Min
            flag = true;

            IVille ville = new Ville(j.getUser(), carte);
            ville = VilleService.getInstance().createVille(ville);


            while (flag) {
                randomX = randomGenerator.nextInt(game.getMapSize().getX());
                randomY = randomGenerator.nextInt(game.getMapSize().getY());

                Territoire t = searchTerritoireByCoo(carte.getTerritoires(), randomX, randomY);

                if (t != null && null == t.getVilles()) {
                    t.setVilles(ville);
                    //t.setOwner(j.getUser()); // TODO faire un service qui gere les Owner de territoire
                    flag = false;
                }
            }
        }

        UnitOfWork.getInstance().commit();
    }

    private Territoire searchTerritoireByCoo(List<Territoire> territoires, int x, int y) {

        return territoires.stream()
                .filter(o -> o.getCoordonnees().getX().equals(x) && o.getCoordonnees().getY().equals(y))
                .findAny()
                .orElse(null);

    }
}
