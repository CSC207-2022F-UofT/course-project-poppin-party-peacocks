import java.util.Comparator;
public class ItemPriceComparator implements Comparator<Item> {
    //compares two item by their price
    // rn this code is sorting L-H which should be default
    // if we want H-L, switch first if statement to <= and else if to >=

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
