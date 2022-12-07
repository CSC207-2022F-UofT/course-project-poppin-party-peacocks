package GUI;
import javax.swing.*;
import java.awt.*;

public class ToggleCurrencyButton extends JButton{

    public ToggleCurrencyButton(){
        super();
    }


    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(106, 189, 154));
        g2.fillRect(0, 0, getWidth(), getHeight());
        this.setBorderPainted(false);
        ImageIcon img = new ImageIcon("src/main/java/Assets/cadIcon.png");
        img.paintIcon(this, g, 0, 0);
    }
}
