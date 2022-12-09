package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Custom delete JButton. Used for deleting an entity instance.
 */
public class DeleteButton extends JButton {

    /**
     * DeleteButton constructor.
     */
    public DeleteButton(){
        super();
    }

    /**
     * Paints delete button with gradient and adds "deleteButton.png" icon.
     * @param g the <code>Graphics</code> object to protect
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
        ImageIcon img = new ImageIcon("src/main/java/Assets/deleteButton.png");
        img.paintIcon(this, g, 0, 0);
    }
}
