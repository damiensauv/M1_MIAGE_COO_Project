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
    private JButton cancel;
    private JList<String> jListgame;

    public AwaytingGamePanel(MyFrame frame) {
        super(frame);

        launch = new JButton("launch");
        cancel = new JButton("cancel");

        this.add(launch);
        this.add(cancel);
        launch.addActionListener(this);
        cancel.addActionListener(this);

        List<IGame> listGames = GameService.getInstance().getAwaytingGame();
        DefaultListModel<String> listModel = new DefaultListModel<String>();

        for (IGame game : listGames) {
            listModel.addElement(game.getName());
        }

        jListgame = new JList<String>(listModel);
        this.add(jListgame);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == launch) {

            this.getMyFrame().switchPanel(new CartePanel(this.getMyFrame()));


        } else if (e.getSource() == cancel) {
            this.getMyFrame().switchPanel(new MainPanel(this.getMyFrame()));
        }


    }
}
