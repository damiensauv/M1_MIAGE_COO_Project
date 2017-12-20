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
            IGame game = jListgame.getSelectedValue();

            Integer ret = GameService.getInstance().launchGame(game);
            if (ret == 1)
                JOptionPane.showMessageDialog(this, "Tu n'est pas le proprio");
            else if (ret == 2)
                JOptionPane.showMessageDialog(this, "Tu est seul");
            else if (ret == 3)
                JOptionPane.showMessageDialog(this, "Carte Trop petite");// TODO a gere a la creation

//            this.getMyFrame().switchPanel(new CartePanel(this.getMyFrame()));


        } else if (e.getSource() == cancel) {
            this.getMyFrame().switchPanel(new MainPanel(this.getMyFrame()));
        } else if (e.getSource() == rejoin) {
            IGame game = jListgame.getSelectedValue();
            Integer ret = GameService.getInstance().addCurrentJoueur(game);
            if (ret > 0)
                JOptionPane.showMessageDialog(this, "Action non possible");
            else if (ret == 0)
                JOptionPane.showMessageDialog(this, "Bien ajouter a la partie");
        }


    }
}
