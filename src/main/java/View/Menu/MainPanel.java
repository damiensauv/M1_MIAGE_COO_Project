package View.Menu;

import Service.UserService;
import View.utils.MyFrame;
import View.utils.MyPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends MyPanel implements ActionListener {

    private JButton createGameButton;
    private JButton histoGame;
    private JButton logout;
    private JButton awaytingGame;
    private JButton inProgressGame;

    public MainPanel(MyFrame frame) {
        super(frame);

        createGameButton = new JButton("Crée une Partie");
        histoGame = new JButton("Historique des parties");
        logout = new JButton("deconnexion");
        awaytingGame = new JButton("Partie en attente");
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

    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
        if (source == createGameButton) {
            this.getMyFrame().switchPanel(new CreateGamePanel(this.getMyFrame()));
        } else if (source == histoGame) {
            this.getMyFrame().switchPanel(new HistoGamePanel(this.getMyFrame()));
        } else if (source == logout) {
            UserService.getInstance().disconet();
            this.getMyFrame().switchPanel(new ConnexionPanel(this.getMyFrame()));
        } else if (source == awaytingGame) {
            this.getMyFrame().switchPanel(new AwaytingGamePanel(this.getMyFrame()));
        } else if (source == inProgressGame) {
            this.getMyFrame().switchPanel(new InProgressGamePanel(this.getMyFrame()));
        }

    }
}
