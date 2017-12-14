package View.Game;

import View.utils.MyFrame;
import View.utils.MyPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CartePanel extends MyPanel implements MouseListener {
    public CartePanel(MyFrame frame) {
        super(frame);


        this.setLayout(new GridLayout(4, 4));
        this.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));


        /// TODO : Panel qui contient des panels
        for (int i =0; i<(4*4); i++){
            final JLabel label = new JLabel();
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            this.add(label);
        }

        addMouseListener(this);

        this.setPreferredSize(new Dimension(300, 230));
        this.setBackground(Color.white);
    }

    public void mouseClicked(MouseEvent e) {
        System.out.println("Click");
    }

    public void mousePressed(MouseEvent e) {
        System.out.println("Pressed");
    }

    public void mouseReleased(MouseEvent e) {
        System.out.println("Relase");
    }

    public void mouseEntered(MouseEvent e) {
        System.out.println("Entered");
    }

    public void mouseExited(MouseEvent e) {
        System.out.println("Exite");
    }
}
