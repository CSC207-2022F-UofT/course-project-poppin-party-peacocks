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
    }

    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(panelColor);
        g2.fillRoundRect(0,0,getWidth()-1,getHeight()-1,20,20);
        g2.setColor(borderColor);
        g2.drawRoundRect(0,0,getWidth()-1,getHeight()-1,20,20);
        g2.drawRoundRect(7,7, getHeight()-15, getHeight()-15, 20,20);

        Image image = img.getImage();
        Image scaledImg = image.getScaledInstance(85,85, Image.SCALE_DEFAULT);
        img = new ImageIcon(scaledImg);
        img.paintIcon(null, g2, 6,6);

        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Montserrat", Font.PLAIN, 18));
        g2.drawString(itemName, 100,25);
        g2.setFont(new Font("Montserrat", Font.PLAIN, 12));
        g2.drawString(itemPrice, 100, 40);
    }
}
