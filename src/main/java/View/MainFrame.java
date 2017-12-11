package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends MyFrame implements ActionListener {

    JButton createGameButton;
    JButton histoGame;
    JButton logout;
    JButton awaytingGame;
    JButton inProgressGame;
    JPanel  mainPanel;

    public MainFrame(){
        createGameButton = new JButton("Crée une Partie");
        histoGame = new JButton("Historique des parties");
        logout = new JButton("deconnexion");
        awaytingGame = new JButton("Partie en tete");
        inProgressGame = new JButton("Partie en cours");

        mainPanel = new JPanel();

        createGameButton.addActionListener(this);
        histoGame.addActionListener(this);
        logout.addActionListener(this);
        awaytingGame.addActionListener(this);
        inProgressGame.addActionListener(this);

        mainPanel.add(createGameButton);
        mainPanel.add(histoGame);
        mainPanel.add(logout);
        mainPanel.add(awaytingGame);
        mainPanel.add(inProgressGame);


        this.setContentPane(mainPanel);
    }

    public void actionPerformed(ActionEvent actionEvent) {


    }
}
