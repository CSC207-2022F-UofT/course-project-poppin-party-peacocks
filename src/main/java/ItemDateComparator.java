import java.util.Comparator;

public class ItemDateComparator implements Comparator<Item> {
    //compares two items by their dates, where the more recent the date, the higher the order
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
