package Persistance.Factory;

import Jeu.Interface.IUser;
import Persistance.DataMapper.UserMapper;

public class UserFactory implements Factory<IUser> {

    private Integer id;

    public UserFactory(Integer id) {
        this.id = id;
    }

    public IUser create() {
        IUser user = UserMapper.getInstance().find(this.id);
        return user;
    }
}
