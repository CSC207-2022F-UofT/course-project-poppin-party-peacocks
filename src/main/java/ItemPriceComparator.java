import java.util.Comparator;
public class ItemPriceComparator implements Comparator<Item> {
    //compares two item by their price

    @Override
    public int compare(Item item1, Item item2) {
        if (item1.getItemPrice() >= item2.getItemPrice()) {
            return 1;
        }
        else if (item1.getItemPrice() <= item2.getItemPrice()) {
            return -1;
        }
        else {
            return 0;
        }
    }

}
