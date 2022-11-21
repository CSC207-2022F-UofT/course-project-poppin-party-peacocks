package Entities;
import java.util.Comparator;

public class ItemNameComparator implements Comparator<Item> {
    /**
     * Takes 2 Items and compares their names using .getItemName()
     * Default saved comparison: A-Z (ascending)
     * @param item1 The first name of Entities.Item
     * @param item2 The second name of Entities.Item
     * @return returns 1 if item1's name is after item2's name,
     * returns -1 if item1's name is before item2's name,
     * returns 0 otherwise
     */
    @Override
    public int compare(Item item1, Item item2) {
        return (item1.getItemName().compareTo(item2.getItemName()));
    }
}
