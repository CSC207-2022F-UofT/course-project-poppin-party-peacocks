package GUI;

import javax.swing.border.Border;
import java.awt.*;

/**
 * RoundedBorder class implements the default Border class to allow us to specify the border radii of our
 * CustomJButtons.
 */
public class RoundedBorder implements Border {
    private final int radius;

    /**
     * RoundedBorder class constructor.
     * @param radius border radius (in pixels).
     */
    RoundedBorder(int radius) {
        this.radius = radius;
    }

    /**
     * Defines default insets.
     * @param c the component for which this border insets value applies
     * @return Insets object with the given border radius.
     */
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
    }

    /**
     * @return whether border is opaque.
     */
    public boolean isBorderOpaque() {
        return true;
    }

    /**
     * Draws rounded border with Graphics.
     * @param c the component for which this border is being painted
     * @param g the paint graphics
     * @param x the x position of the painted border
     * @param y the y position of the painted border
     * @param width the width of the painted border
     * @param height the height of the painted border
     */
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
    }
}