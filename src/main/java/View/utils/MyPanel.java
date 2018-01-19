package View.utils;

import View.utils.MyFrame;

import javax.swing.*;

public class MyPanel extends JPanel {

    // sert a gere plus facilement les Panels
    private MyFrame myFrame;

    public MyPanel(MyFrame frame) {
        this.myFrame = frame;
    }


    public MyFrame getMyFrame() {
        return myFrame;
    }

    public void setMyFrame(MyFrame myFrame) {
        this.myFrame = myFrame;
    }


}
