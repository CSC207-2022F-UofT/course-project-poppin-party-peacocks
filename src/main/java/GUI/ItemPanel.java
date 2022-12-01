package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

/**
 * A GUI class used to create a visual representation of an item inside a list.
 * Contains an image, name, and price of the item. Details of the item can instead be seen in the ItemPage.
 */
public class ItemPanel extends JPanel {

    String imgURL;
    String itemName;
    String itemPrice;
    Color borderColor;
    Color panelColor;
    ImageIcon img;


    public ItemPanel(String imgURL, String itemName, String itemPrice) {
        super(null);
        this.imgURL = imgURL;
        if (itemName.length() > 20){
            this.itemName = itemName.substring(0,20) + "...";
        }else{
            this.itemName = itemName;
        }
        this.itemPrice = itemPrice;
        this.setSize(300,100);
        borderColor = Color.WHITE;
        panelColor = new Color(236, 236, 236);
    }

    /**
     * Sets the color of the back panel of the ItemPanel to c
     * @param c - color to set the panel to
     */
    public void setPanelColor(Color c){
        this.panelColor = c;
    }

    /**
     * Overrides the paintComponent method inheritted from JPanel.
     * Creates a visual representation of an item, which is displayed in the wishlist.
     * @param g the Graphics object to protect
     */
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(panelColor);
        g2.fillRoundRect(0,0,getWidth()-1,getHeight()-1,20,20);
        g2.setColor(borderColor);
        g2.drawRoundRect(0,0,getWidth()-1,getHeight()-1,20,20);

        try {
            URL url = new URL(imgURL);
            Image image = ImageIO.read(url);
            Image scaledImg = image.getScaledInstance(80,80, Image.SCALE_SMOOTH);
            img = new ImageIcon(scaledImg);
            img.paintIcon(null, g2, 10,10);
        }
        catch (IOException e) {
            try{
                URL url = new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/No-Image-Placeholder.svg/1665px-No-Image-Placeholder.svg.png");
                Image image = ImageIO.read(url);
                Image scaledImg = image.getScaledInstance(80,80, Image.SCALE_SMOOTH);
                img = new ImageIcon(scaledImg);
                img.paintIcon(null, g2, 10,10);
            }
            catch (IOException e1){
                e1.printStackTrace();
            }
        }


        g2.drawRect(8,8, getHeight()-17, getHeight()-17);

        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Montserrat", Font.PLAIN, 18));
        g2.drawString(itemName, 100,25);
        g2.setFont(new Font("Montserrat", Font.PLAIN, 12));
        g2.drawString(itemPrice, 100, 60);
    }
}
