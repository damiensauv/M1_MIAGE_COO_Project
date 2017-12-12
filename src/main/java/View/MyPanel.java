package View;

import javax.swing.*;

public class MyPanel extends JPanel {

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
