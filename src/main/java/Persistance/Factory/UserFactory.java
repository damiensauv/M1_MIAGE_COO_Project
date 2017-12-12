package Persistance.Factory;

import Jeu.Interface.IUser;
import Persistance.DataMapper.UserDataMapper;

public class UserFactory implements Factory<IUser> {

    private Integer id;

    public UserFactory(Integer id) {
        this.id = id;
    }

    public IUser create() {
        IUser user = UserDataMapper.getInstance().find(this.id);
        return user;
    }
}
