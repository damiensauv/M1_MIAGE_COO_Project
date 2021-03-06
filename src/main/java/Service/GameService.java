package Service;

import Domain.Entity.Coordonnees;
import Domain.Entity.Game;
import Domain.Entity.Status;
import Domain.Entity.Territoire;
import Domain.Interface.IGame;
import Domain.Interface.IJoueur;
import Domain.Interface.IUser;
import Persistance.DataMapper.GameMapper;
import Persistance.DataMapper.JoueurMapper;
import Util.UnitOfWork;

import java.sql.SQLException;
import java.util.List;


public class GameService {

    private static GameService instance = null;

    public static GameService getInstance() {
        if (instance == null) {
            instance = new GameService();
        }
        return instance;
    }

    private GameService() {

    }

    public void createGame(Coordonnees coordonnees, Integer maxUser, Integer nbInitRes, Integer nbResTurn, Integer timeTurn, String name, Integer distance) throws SQLException {

        IGame game = new Game(name,
                Status.awayting,
                UserService.getInstance().getConnectedUser(),
                coordonnees,
                maxUser,
                nbInitRes,
                nbResTurn,
                timeTurn,
                distance,
                CarteService.getInstance().createCarte(coordonnees)
        );

        Integer idx = GameMapper.getInstance().insert(game);
        UnitOfWork.getInstance().commit();

        IGame g = GameMapper.getInstance().find(idx);
        this.addCurrentJoueur(g);
    }

    public void updateGame(Game game) {

    }

    public Game getGame(Integer id) {
        return null;
    }

    public List<Game> getActiveGameOfPlayer(Integer idUser) {
        return null;
    }

    public List<IGame> getAwaytingGame() {
        return GameMapper.getInstance().findAllGamesByStatus(Status.awayting);
    }


    public boolean isUserInGame(int id_game, int id_user) {
        return JoueurMapper.getInstance().isUserInGame(id_game, id_user);
    }

    public Integer addCurrentJoueur(IGame game) {
        IUser u = UserService.getInstance().getConnectedUser();

        // le joueur est deja dans la game
        if (this.isUserInGame(game.getId(), u.getId())) {
            return 1;
        } else if (game.getUserInGame().size() == game.getMaxUser()) {
            return 2;
        } else {
            try {
                IJoueur j = JoueurService.getInstance().createJoueur(game, u);
                game.addUserInGame(j);
                UnitOfWork.getInstance().commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public void initGame(IGame game) {

        CarteService.getInstance().initVille(game);
        setOwnerTerritoire(game.getCarte().getTerritoires());
        initRessourcePlayer(game, game.getNbInitRes());
        game.setStatus(Status.InProgress);
        UnitOfWork.getInstance().commit();
    }

    private void initRessourcePlayer(IGame game, Integer ressource) {

        for (IJoueur j : game.getUserInGame()) {
            j.setRessource(ressource);
        }
        UnitOfWork.getInstance().commit();
    }

    private void setOwnerTerritoire(List<Territoire> ts) {

        for (Territoire t : ts) {
            if (null == t.getVilles()) {
                // on check par armée TODO
            } else {
                IUser u = t.getVilles().getJoueur();
                t.setOwner(u);
            }
        }
        UnitOfWork.getInstance().commit();
    }

    public Integer launchGame(IGame game) {
        IUser u = UserService.getInstance().getConnectedUser();

        if (!game.getOwner().equals(u))
            return 1;

        if (game.getUserInGame().size() <= 1)
            return 2;
        if (game.getUserInGame().size() >= (game.getMapSize().getY() * game.getMapSize().getX()))
            return 3;

        this.initGame(game);

        return 0;
    }

    public List<IGame> getInProgressGame() {
        return GameMapper.getInstance().findAllGamesByStatusInProgress(UserService.getInstance().getConnectedUser());
    }

    public List<IGame> getHistoGame() {
        return GameMapper.getInstance().findAllGamesByStatus(Status.finish);
    }
}
