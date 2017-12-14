package View.Menu;

import View.utils.MyFrame;
import View.utils.MyPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AwaytingGamePanel extends MyPanel implements ActionListener {

    private JButton launch;
    private JButton cancel;
    private JList<String> listgame;


    public AwaytingGamePanel(MyFrame frame) {
        super(frame);

        launch = new JButton("launch");
        cancel = new JButton("cancel");

        this.add(launch);
        this.add(cancel);
        launch.addActionListener(this);
        cancel.addActionListener(this);

        DefaultListModel<String> listModel = new DefaultListModel<String>();
        listModel.addElement("USA");
        listModel.addElement("India");
        listModel.addElement("Vietnam");

        listgame = new JList<String>(listModel);
        this.add(listgame);



    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == launch) {
            // launch game
        } else if (e.getSource() == cancel) {
            this.getMyFrame().switchPanel(new MainPanel(this.getMyFrame()));
        }


    }
}
