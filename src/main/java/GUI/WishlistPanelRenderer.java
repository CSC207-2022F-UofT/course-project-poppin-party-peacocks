package GUI;

import javax.swing.*;
import java.awt.*;

public class WishlistPanelRenderer implements ListCellRenderer<Object> {
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        WishlistPanel wishlistPanel = (WishlistPanel) value;
        Color defaultColor = new Color(194, 234, 186);
        Color selectedColor = new Color(148, 208, 161);
        if (isSelected) {
            wishlistPanel.setPanelColor(selectedColor);
        } else {
            wishlistPanel.setPanelColor(defaultColor);
        }
        return wishlistPanel;
    }
}
