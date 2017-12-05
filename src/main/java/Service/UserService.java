package Service;

import Jeu.Entity.User;
import Jeu.Interface.IUser;
import Persistance.DataMapper.UserDataMapper;

import java.util.List;

public class UserService {

    private static UserService instance = null;
    private IUser connectedUser = null;

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

        connectedUser = UserDataMapper.getInstance().findByUsername(username);

        if (connectedUser.getPassword().equals(password)) {
            System.out.println("Password ok for : " + connectedUser.getUsername());
            return connectedUser;
        } else {
            System.out.println("Password not Match !!"); // TODO : Lever un Exception !!
            return null;
        }
    }

    public IUser getConnectedUser() {
        return connectedUser;
    }

    public static void setInstance(UserService instance) {
        UserService.instance = instance;
    }

    public List<User> getAllUser(){
        return null;
    }

}
