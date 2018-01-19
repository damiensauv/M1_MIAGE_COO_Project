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
