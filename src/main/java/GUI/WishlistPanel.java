package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * A GUI class used to create a visual representation of a list of wishlists.
 * Contains the name of the wishlist.
 */
public class WishlistPanel extends JPanel {

    String wishlistName;
    Color borderColor;
    Color panelColor;

    public WishlistPanel(String wishlistName) {
        super(null);
        if (wishlistName.length() > 20){
            this.wishlistName = wishlistName.substring(0,20) + "...";
        }else{
            this.wishlistName = wishlistName;
        }
        this.setSize(300,75);
        borderColor = Color.WHITE;
        panelColor = new Color(236, 236, 236);
    }

    /**
     * Sets the color of the back panel of the WishlistPanel to c
     * @param c - color to set the panel to
     */
    public void setPanelColor(Color c){
        this.panelColor = c;
    }

    /**
     * Overrides the paintComponent method inherited from JPanel.
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

        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Montserrat", Font.PLAIN, 18));
        g2.drawString(wishlistName, 10,25);
    }
}
