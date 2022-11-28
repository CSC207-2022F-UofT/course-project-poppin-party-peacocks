package GUI;

import GUI.RoundedBorder;

import javax.swing.*;
import java.awt.*;

public class CustomJButton extends JButton {
    private String text;
    private int prefWidth;
    private int prefHeight;
    private Color background;
    private Color foreground;
    private Font font;

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
