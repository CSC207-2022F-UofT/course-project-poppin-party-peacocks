package GUI;

import javax.swing.*;
import java.awt.*;

public class ItemPanelRenderer implements ListCellRenderer<Object> {
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        ItemPanel itemPanel = (ItemPanel) value;
        Color defaultColor = new Color(194, 234, 186);
        Color selectedColor = new Color(148, 208, 161);
        if (isSelected) {
            itemPanel.setPanelColor(selectedColor);
        } else {
            itemPanel.setPanelColor(defaultColor);
        }
        return itemPanel;
    }
}
