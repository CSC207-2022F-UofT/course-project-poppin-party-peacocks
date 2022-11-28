package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class BackButton extends JButton{

    public BackButton(){
        super();

    }

    @Override
    protected void paintComponent(Graphics g) {
        this.setBorderPainted(false);
        ImageIcon img = new ImageIcon("src/main/java/Assets/backArrow.png");
        img.paintIcon(this,g,0,0);
    }
}
