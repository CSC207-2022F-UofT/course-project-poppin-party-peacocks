package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * A custom JButton. The refresh button at the top right of the wishlist page.
 */
public class RefreshButton extends JButton{
    /**
     * constructor. Calls the default JButton constructor.
     */
    public RefreshButton(){super();}

    /**
     * overrides the paintComponent method. Paints the button's background and icon.
     * @param g the Graphics object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(106, 189, 154));
        g2.fillRect(0, 0, getWidth(), getHeight());
        this.setBorderPainted(false);
        ImageIcon img = new ImageIcon("src/main/java/Assets/refreshButton.png");
        img.paintIcon(this, g, 0, 0);
    }
}
