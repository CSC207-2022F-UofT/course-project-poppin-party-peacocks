import java.util.Comparator;
public class ItemNameComparator implements Comparator<Item>{
    // compares two items by their name, from A-Z or Z-A

    @Override
    public int compare(Item item1, Item item2) {
//        if () {
//            return 1;
//        } else if () {
//            return -1;
//        } else {
//            return 0;
//        }
        return item1.getItemName().compareTo(item2.getItemName());

    }
}
