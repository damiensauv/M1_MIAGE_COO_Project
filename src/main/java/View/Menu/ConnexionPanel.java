package View.Menu;

import Service.UserService;
import View.utils.MyFrame;
import View.utils.MyPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnexionPanel extends MyPanel implements ActionListener {

    private JButton login;
    private TextField username;
    private TextField password;

    public ConnexionPanel(MyFrame frame) {
        super(frame);

        username = new TextField(25);
        password = new TextField(25);
        login = new JButton("Login");

        this.add(new JLabel("username : "));
        this.add(username);
        this.add(new JLabel("password : "));
        this.add(password);
        this.add(login);
        login.addActionListener(this);

        // a revoir
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    public void actionPerformed(ActionEvent e) {

        this.getMyFrame().switchPanel(new MainPanel(this.getMyFrame()));
        /*
        if (e.getSource() == login) {
            boolean c = UserService.getInstance().connexion(this.username.getText().trim(), this.password.getText().trim());
            if (c) {

            } else {
                JOptionPane.showMessageDialog(this, "Erreur dans le username ou mot de passe !");
            }
        }
*/
    }
}
