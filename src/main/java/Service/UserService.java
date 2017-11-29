package Service;

import Jeu.Interface.IUser;
import Persistance.DataMapper.UserDataMapper;

public class UserService {

    private static UserService instance = null;

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    private UserService() {
    }

    // Test : si username not in BDD
    public IUser connexion(String username, String password) {

        IUser u = UserDataMapper.getInstance().findByUsername(username);

        if (u.getPassword().equals(password)) {
            System.out.println("Password ok for : " + u.getUsername());
            return u;
        } else {
            System.out.println("Password not Match !!"); // TODO : Lever un Exception !!
            return null;
        }
    }


}
