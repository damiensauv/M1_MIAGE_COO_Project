import Jeu.Interface.IUser;
import Service.GameService;
import Service.UserService;
import View.ConnexionFrame;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        /*
        IUser u = UserService.getInstance().connexion("damien", "123456");
        u = UserService.getInstance().connexion("damien", "123456");
        System.out.println("User Co ==> " + u.getUsername());
        GameService gs  = GameService.getInstance();

    */
        ConnexionFrame cf = new ConnexionFrame();

        cf.setLocationRelativeTo(null);
        cf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cf.setVisible(true);
        cf.setSize(1000, 300);


    }

}
