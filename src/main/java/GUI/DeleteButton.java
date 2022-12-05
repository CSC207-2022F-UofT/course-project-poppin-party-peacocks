package GUI;

import javax.swing.*;
import java.awt.*;

public class DeleteButton extends JButton {

    public DeleteButton(){
        super();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Color topColor = new Color(118, 195, 158);
        Color botColor = new Color(110, 191, 155);
        GradientPaint gp = new GradientPaint(getWidth() / 2, 0, topColor, getWidth() / 2, getHeight(), botColor);
        g2.setPaint(gp);
        g2.fillRect(0, 0, getWidth(), getHeight());
        this.setBorderPainted(false);
        ImageIcon img = new ImageIcon("src/main/java/Assets/deleteButton.png");
        img.paintIcon(this, g, 0, 0);
    }
}
