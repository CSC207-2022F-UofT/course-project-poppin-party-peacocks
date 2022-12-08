package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Renders each item as a JPanel.
 */
public class ItemPanelRenderer implements ListCellRenderer<Object> {
    /**
     * Renders an item with constant colours depending on whether its selected at the moment.
     * @param list The JList we're painting.
     * @param value The value returned by list.getModel().getElementAt(index).
     * @param index The cells index.
     * @param isSelected True if the specified cell was selected.
     * @param cellHasFocus True if the specified cell has the focus.
     * @return item panel to be rendered.
     */
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
