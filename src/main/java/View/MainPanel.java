package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends MyPanel implements ActionListener {

    JButton createGameButton;
    JButton histoGame;
    JButton logout;
    JButton awaytingGame;
    JButton inProgressGame;

    public MainPanel(MyFrame frame){
        super(frame);

        createGameButton = new JButton("Crée une Partie");
        histoGame = new JButton("Historique des parties");
        logout = new JButton("deconnexion");
        awaytingGame = new JButton("Partie en tete");
        inProgressGame = new JButton("Partie en cours");


        createGameButton.addActionListener(this);
        histoGame.addActionListener(this);
        logout.addActionListener(this);
        awaytingGame.addActionListener(this);
        inProgressGame.addActionListener(this);

        this.add(createGameButton);
        this.add(histoGame);
        this.add(logout);
        this.add(awaytingGame);
        this.add(inProgressGame);

    }

    public void actionPerformed(ActionEvent actionEvent) {


    }
}
