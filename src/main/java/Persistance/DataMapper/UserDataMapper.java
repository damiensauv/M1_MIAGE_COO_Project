package Persistance.DataMapper;

import Jeu.Entity.User;
import Jeu.Interface.IUser;

public class UserDataMapper extends DataMapper<IUser> {

    private static UserDataMapper instance = null;

    public static UserDataMapper getInstance() {
        if (instance == null) {
            instance = new UserDataMapper();
        }
        return instance;
    }

    private UserDataMapper() {
    }


    IUser find(Integer id) {

        /*
        IUser p = idMap.get(id);
        if (p != null) {
            System.out.println("Get from IdMap");
            return p;
        }
        */
        // Code Temporaire


        return null;
    }

    void insert(IUser o) {

    }

    void delete(IUser o) {

    }

    void update(IUser o) {

    }


}
