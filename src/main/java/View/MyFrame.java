package View;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    JPanel cardpanels;

    public MyFrame()
    {
        cardpanels = new JPanel();
        cardpanels.setLayout(new CardLayout());
    }

    public JPanel getCardpanels() {
        return cardpanels;
    }

    public void setCardpanels(JPanel cardpanels) {
        this.cardpanels = cardpanels;
    }

}
