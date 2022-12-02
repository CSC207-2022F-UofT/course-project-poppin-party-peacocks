package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Custom JLabel class. Allows us to more easily create JLabels with custom text, colour, and font.
 */
public class CustomJLabel extends JLabel {

    /**
     * Custom JLabel constructor.
     * @param text label text
     * @param foreground text colour
     * @param font text font
     */
    public CustomJLabel(String text, Color foreground, Font font) {
        super(text);
        this.setFont(font);
        this.setForeground(foreground);
    }
}
