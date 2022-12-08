package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Renders each item search result as a JPanel.
 */
public class PanelRenderer implements ListCellRenderer<Object> {
    public Component getListCellRendererComponent(JList list, Object value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        JPanel renderer = (JPanel) value;
        renderer.setBackground(isSelected ? Color.red : list.getBackground());
        Color defaultColor = new Color(194, 234, 186);
        Color selectedColor = new Color(106, 189, 154);
        BorderLayout layout = (BorderLayout) renderer.getLayout();
        if (isSelected) {
            layout.getLayoutComponent(BorderLayout.CENTER).setBackground(selectedColor);
            renderer.setBackground(selectedColor);
            renderer.setForeground(selectedColor);
        } else {
            layout.getLayoutComponent(BorderLayout.CENTER).setBackground(defaultColor);
            renderer.setBackground(defaultColor);
            renderer.setForeground(defaultColor);
        }
        return renderer;
    }
}
