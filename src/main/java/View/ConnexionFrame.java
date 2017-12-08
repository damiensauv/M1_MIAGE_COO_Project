package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnexionFrame extends JFrame implements ActionListener {

    JButton login;
    TextField username;
    TextField password;
    JPanel panelCo;

    public ConnexionFrame() {

        username = new TextField(25);
        password = new TextField(25);
        login = new JButton("Login");

        panelCo = new JPanel();

        panelCo.add(new JLabel("username : "));
        panelCo.add(username);

        panelCo.add(new JLabel("password : "));
        panelCo.add(password);

        panelCo.add(login);
        login.addActionListener(this);

        this.setContentPane(panelCo);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == login){

            // get username & password
            // call Service
            // Call Menu

        }

    }
}
