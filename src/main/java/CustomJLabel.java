import javax.swing.*;
import java.awt.*;

public class CustomJLabel extends JLabel {
    private String text;
    private Color foregroundColor;
    private Font font;

    public CustomJLabel(String text, Color foreground, Font font) {
        super(text);
        this.setFont(font);
        this.setForeground(foregroundColor);
    }
}
