package GUI;

import javax.swing.*;
import java.awt.*;

public class ItemPanel extends JPanel {

    ImageIcon img;
    String itemName;
    String itemPrice;
    Color borderColor;
    Color panelColor;


    public ItemPanel(ImageIcon img, String itemName, String itemPrice) {
        super(null);
        this.img = img;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.setSize(300,100);
        borderColor = Color.WHITE;
        panelColor = new Color(236, 236, 236);
        //this.setBackground(panelColor);
    }

    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(panelColor);
        g2.fillRoundRect(0,0,getWidth()-1,getHeight()-1,20,20);
        g2.setColor(borderColor);
        g2.drawRoundRect(0,0,getWidth()-1,getHeight()-1,20,20);

    }
}
