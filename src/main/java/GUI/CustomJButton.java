package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Custom JButton class. Allows us to more easily create JButton with custom text, colour, and font.
 */

public class CustomJButton extends JButton {

    /**
     * Custom JButton constructor.
     * @param text button text
     * @param prefWidth button width, set to 0 for default button width
     * @param prefHeight button height, set to 0 for default button height
     * @param background button background
     * @param foreground button foreground (this includes the button text)
     * @param font font of button text
     */

    public CustomJButton(String text, int prefWidth, int prefHeight, Color background, Color foreground, Font font) {
        super();
        this.setText(text);
        this.setFont(font);
        this.setBorder(new RoundedBorder(20));

        // Preserve default width and height.
        if (prefHeight > 0 && prefWidth > 0) {
            this.setPreferredSize(new Dimension(prefWidth, prefHeight));
        }
        this.setBackground(background);
        this.setForeground(foreground);
        this.setContentAreaFilled(false);
    }
}
