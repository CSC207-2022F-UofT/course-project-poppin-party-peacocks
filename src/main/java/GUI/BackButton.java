package GUI;
import javax.swing.*;
import java.awt.*;

/**
 * Variation of a custom JButton specific for returning to a previous page.
 */
public class BackButton extends JButton{

    /**
     * BackButton constructor.
     */
    public BackButton(){
        super();
    }

    /**
     * Colour's BackButton.
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(106, 189, 154));
        g2.fillRect(0,0,getWidth(),getHeight());
        this.setBorderPainted(false);
        ImageIcon img = new ImageIcon("src/main/java/Assets/backArrow.png");
        img.paintIcon(this,g,0,0);
    }
}
