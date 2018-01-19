package View.Menu;

import Domain.Interface.IGame;
import Service.GameService;
import View.utils.MyFrame;
import View.utils.MyPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class InProgressGamePanel extends MyPanel implements ActionListener {

    private JButton launch;
    private JButton cancel;
    private JList<IGame> jListgame;

    public InProgressGamePanel(MyFrame frame) {
        super(frame);

        List<IGame> listGames = GameService.getInstance().getInProgressGame();

        launch = new JButton("launch");
        cancel = new JButton("cancel");

        this.add(launch);
        this.add(cancel);

        launch.addActionListener(this);
        cancel.addActionListener(this);

        if (listGames != null) {
            DefaultListModel<IGame> listModel = new DefaultListModel<IGame>();
            for (IGame game : listGames) {
                listModel.addElement(game);
            }
            jListgame = new JList<IGame>(listModel);
            this.add(jListgame);
            this.add(new JScrollPane(jListgame));
        }
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == launch) {
            IGame game = jListgame.getSelectedValue();


        } else if (e.getSource() == cancel) {
            this.getMyFrame().switchPanel(new MainPanel(this.getMyFrame()));
        }


    }
}
