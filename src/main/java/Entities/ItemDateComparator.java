package Entities;
import java.util.Comparator;

public class ItemDateComparator implements Comparator<Product> {
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
    public int compare(Product item1, Product item2){
        if(item1.getProductDateAdded().after(item2.getProductDateAdded())){
            return 1;
        } else if (item1.getProductDateAdded().before(item2.getProductDateAdded())){
            return -1;
        } else {
            return 0;
        }
    }
}
