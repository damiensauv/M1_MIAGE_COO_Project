package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateGamePanel extends MyPanel implements ActionListener {

    private JButton confirm;
    private JButton cancel;

    private TextField mapSizeX;
    private TextField mapSizeY;
    private TextField maxUser;
    private TextField nbInitRes;
    private TextField nbResTurn;
    private TextField timeTurn;


    public CreateGamePanel(MyFrame myFrame) {
        super(myFrame);

        confirm = new JButton("confirm");
        cancel = new JButton("cancel");
        mapSizeX = new TextField(25);
        mapSizeY = new TextField(25);
        maxUser = new TextField(25);
        nbInitRes = new TextField(25);
        nbResTurn = new TextField(25);
        timeTurn = new TextField(25);

        confirm.addActionListener(this);
        cancel.addActionListener(this);

        this.add(new JLabel("Map x : "));
        this.add(mapSizeX);
        this.add(new JLabel("Map y : "));
        this.add(mapSizeY);
        this.add(new JLabel("Max User : "));
        this.add(maxUser);
        this.add(new JLabel("Nb Init Resource : "));
        this.add(nbInitRes);
        this.add(new JLabel("Nb Resource by turn : "));
        this.add(nbResTurn);
        this.add(new JLabel("Time Turn (min) : "));
        this.add(timeTurn);

        this.add(confirm);
        this.add(cancel);

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
        if (source == confirm) {

            // Create the Game and Back to Main

        }else if (source == cancel){
            // return MainMenu
        }


    }
}
