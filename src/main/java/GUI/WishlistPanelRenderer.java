package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * custom Cell Renderer for the JList in Homepage. Renders the background of a wishlist panel.
 */
public class WishlistPanelRenderer implements ListCellRenderer<Object> {
    /**
     * Takes in a swing component to render. After changing its appearance, return to the JList.
     * @param list The JList we're painting.
     * @param value The value returned by list.getModel().getElementAt(index).
     * @param index The cells index.
     * @param isSelected True if the specified cell was selected.
     * @param cellHasFocus True if the specified cell has the focus.
     * @return The component to passed back to the JList to render
     */
    @Override
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
