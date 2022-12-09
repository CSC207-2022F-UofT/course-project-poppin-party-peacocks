package GUI;

import javax.swing.*;
import java.awt.*;

public class AddButton extends JButton {

    /**
     * AddButton constructor.
     */
    public AddButton(){
        super();
    }

    /**
     * Paints button gradient and adds "addButton.png" as its icon.
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Color topColor = new Color(118,195,158);
        Color botColor = new Color(110,191,155);
        GradientPaint gp = new GradientPaint(getWidth()/2.0f, 0, topColor, getWidth()/2.0f, getHeight(), botColor);
        g2.setPaint(gp);
        g2.fillRect(0,0,getWidth(),getHeight());
        this.setBorderPainted(false);
        ImageIcon img = new ImageIcon("src/main/java/Assets/addButton.png");
        img.paintIcon(this,g,0,0);
    }
}
