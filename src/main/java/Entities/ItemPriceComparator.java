package Entities;

import Entities.Item;

import java.util.Comparator;
public class ItemPriceComparator implements Comparator<Item>{
    /**
     * Takes 2 Items and compares their prices using .getItemPrice()
     * Defauly saved comparison: Lowest to Highest (ascending)
     * @param item1 The first name of Entities.Item
     * @param item2 The second name of Entities.Item
     * @return returns 1 if item1's price >= item2's price,
     * returns -1 if item1's price <= item2's price,
     * returns 0 otherwise
     */
    @Override
    public int compare(Item item1, Item item2) {
        if (item1.getItemPrice() >= item2.getItemPrice()) {
            return 1;
        } else if (item1.getItemPrice() <= item2.getItemPrice()) {
            return -1;
        } else {
            return 0;
        }
    }
}
