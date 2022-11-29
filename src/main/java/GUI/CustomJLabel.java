package GUI;

import javax.swing.*;
import java.awt.*;

public class CustomJLabel extends JLabel {

    public CustomJLabel(String text, Color foreground, Font font) {
        super(text);
        this.setFont(font);
        this.setForeground(foreground);
    }
}
