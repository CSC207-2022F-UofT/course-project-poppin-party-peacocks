import java.util.Comparator;

public class ItemDateComparator implements Comparator<Item> {
    //compares two items by their dates, where the more recent the date, the higher the order
    /**
     * Takes 2 Items and compares their added dates using .getItemDateAdded() and sorts in ascending order (earliest
     * date-latest date)
     * @param item1 The first name of Item
     * @param item2 The second name of Item
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
