import java.util.Comparator;
public class ItemPriceComparator implements Comparator<Item>{
    /**
     * Takes 2 Items and compares their prices using .getItemPrice() and sorts in ascending order (lowest-highest)
     * @param item1 The first name of Item
     * @param item2 The second name of Item
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
