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

    public boolean connexion(String username, String password) {

        connectedUser = UserDataMapper.getInstance().findByUsername(username);
        // TODO : Return null si pas la !! a gerer

        if (connectedUser.getPassword().equals(password)) {
            System.out.println("Password ok for : " + connectedUser.getUsername());
            return true;
        } else {
            System.out.println("Password not Match !!"); // TODO : Lever un Exception !!
            return false;
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
