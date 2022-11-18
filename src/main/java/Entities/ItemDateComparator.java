package Entities;

import Entities.Item;

import java.util.Comparator;

public class ItemDateComparator implements Comparator<Item> {
    /**
     * Takes 2 Items and compares their added dates using .getItemDateAdded()
     * Default saved comparison: Earliest date to Latest date (ascending)
     * @param item1 The first name of Entities.Item
     * @param item2 The second name of Entities.Item
     * @return returns 1 if item1's added date is after item2's added date,
     * returns -1 if item1's added date is before item2's added date,
     * returns 0 otherwise
     */
    @Override
    public int compare(Item item1, Item item2){
        if(item1.getItemDateAdded().after(item2.getItemDateAdded())){
            return 1;
        } else if (item1.getItemDateAdded().before(item2.getItemDateAdded())){
            return -1;
        } else {
            return 0;
        }
    }
}
