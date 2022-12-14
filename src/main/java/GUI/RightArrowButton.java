package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * a custom JButton. The right arrow button used in wishlist page that views an item.
 */
public class RightArrowButton extends JButton {
    /**
     * constructor. Calls the default JButton constructor.
     */
    public RightArrowButton(){super();}

    /**
     * overrides the paintComponent method to paint the button's icon and background.
     * @param g the Graphics object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Color topColor = new Color(118, 195, 158);
        Color botColor = new Color(110, 191, 155);
        GradientPaint gp = new GradientPaint(getWidth() / 2.0f, 0, topColor, getWidth() / 2.0f, getHeight(), botColor);
        g2.setPaint(gp);
        g2.fillRect(0, 0, getWidth(), getHeight());
        this.setBorderPainted(false);
        ImageIcon img = new ImageIcon("src/main/java/Assets/rightArrow.png");
        img.paintIcon(this, g, 0, 0);
    }
}
