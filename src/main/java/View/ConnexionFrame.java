package View;

import javax.swing.*;
import java.awt.*;

public class ConnexionFrame extends JFrame {

    JButton login;
    TextField username;
    TextField password;
    JPanel panelCo;

    public ConnexionFrame(){

        username = new TextField(25);
        password = new TextField(25);
        login = new JButton("Login");

        panelCo = new JPanel();

        panelCo.add(username);
        panelCo.add(password);
        panelCo.add(login);

        this.setContentPane(panelCo);


    }

}
