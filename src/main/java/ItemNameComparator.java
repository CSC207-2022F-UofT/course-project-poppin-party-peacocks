import java.util.Comparator;

public class ItemNameComparator implements Comparator<Item> {
    /**
     * Takes 2 Items and compares their names using .getItemName() and sorts in ascending order (A-Z)
     * @param item1 The first name of Item
     * @param item2 The second name of Item
     */
    @Override
    public int compare(Item item1, Item item2) {
//        if (item1.getItemName().equals(item2.getItemName())) {
//            return 1;
//        }
        return (item1.getItemName().compareTo(item2.getItemName()));
    }
}
