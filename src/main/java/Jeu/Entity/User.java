package Jeu.Entity;

import Jeu.Interface.IUser;
import Util.Observer;
import Util.UnitOfWork;
import Util.Visitor;

public class User extends AObject implements IUser {

    private String username;
    private String password;

    public User(){
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
        notifier();
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifier();
    }

    public void add(Observer o) {
        obs.add(o);
    }

    public void notifier() {
        for (Observer o : obs)
            o.action(this);
    }

    public void accept(Visitor v) {
        v.visiter(this);
    }

}
