import java.util.Comparator;

public class ItemReviewCountComparator implements Comparator<Item> {
    /**
     * Takes 2 Items and compares their review count using .getReviewCount() and sorts in descending order (highest-lowest)
     * @param item1 The first name of Item
     * @param item2 The second name of Item
     */
    @Override
    public int compare(Item item1, Item item2) {
        if (item1.getReviewCount() <= item2.getReviewCount()) {
            return 1;
        } else if (item1.getReviewCount() >= item2.getReviewCount()) {
            return -1;
        } else {
            return 0;
        }
    }
}
