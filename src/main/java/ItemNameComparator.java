import java.util.Comparator;

public class ItemNameComparator implements Comparator<Item> {
    //compares two items by their names
    @Override
    public int compare(Item item1, Item item2) {
//        if (item1.getItemName().equals(item2.getItemName())) {
//            return 1;
//        }
        return (item1.getItemName().compareTo(item2.getItemName()));
    }
}
