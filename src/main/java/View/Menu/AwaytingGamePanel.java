package View.Menu;

import Jeu.Entity.Game;
import Jeu.Interface.IGame;
import Service.GameService;
import View.Game.CartePanel;
import View.utils.MyFrame;
import View.utils.MyPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AwaytingGamePanel extends MyPanel implements ActionListener {

    private JButton launch;
    private JButton rejoin;
    private JButton cancel;
    private JList<IGame> jListgame;

    public AwaytingGamePanel(MyFrame frame) {
        super(frame);

        launch = new JButton("launch");
        cancel = new JButton("cancel");
        rejoin = new JButton("rejoindre");

        this.add(launch);
        this.add(rejoin);
        this.add(cancel);
        rejoin.addActionListener(this);
        launch.addActionListener(this);
        cancel.addActionListener(this);

        List<IGame> listGames = GameService.getInstance().getAwaytingGame();
        DefaultListModel<IGame> listModel = new DefaultListModel<IGame>();

        for (IGame game : listGames) {
            listModel.addElement(game);
        }

        jListgame = new JList<IGame>(listModel);
        this.add(jListgame);
        this.add(new JScrollPane(jListgame));

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == launch) {

            // check si plus un joueur

            this.getMyFrame().switchPanel(new CartePanel(this.getMyFrame()));


        } else if (e.getSource() == cancel) {
            this.getMyFrame().switchPanel(new MainPanel(this.getMyFrame()));
        } else if (e.getSource() == rejoin) {
            IGame game = jListgame.getSelectedValue();

            // add le joueur co dans la partie, check si limite non atteinte et si il est pas deja dans la game
            Integer ret = GameService.getInstance().addCurrentJoueur(game);
            if (ret > 0)
                JOptionPane.showMessageDialog(this, "Action non possible");


        }


    }
}
