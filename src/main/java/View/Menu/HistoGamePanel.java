package View.Menu;

import Domain.Interface.IGame;
import Service.GameService;
import View.utils.MyFrame;
import View.utils.MyPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class HistoGamePanel extends MyPanel implements ActionListener {

    private JButton backButton;
    private JList<IGame> jListgame;

    public HistoGamePanel(MyFrame frame) {
        super(frame);


        backButton = new JButton("retour");

        this.add(backButton);
        backButton.addActionListener(this);

        List<IGame> listGames = GameService.getInstance().getHistoGame();
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton)
            this.getMyFrame().switchPanel(new MainPanel(this.getMyFrame()));

    }
}
