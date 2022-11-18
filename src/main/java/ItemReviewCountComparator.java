import java.util.Comparator;

public class ItemReviewCountComparator implements Comparator<Item> {
    /**
     * Takes 2 Items and compares their review count using .getReviewCount()
     * Returns 1, -1, 0 depending on the results of the comparison
     * Default saved comparison: Highest to Lowest (descending)
     * @param item1 The first name of Item
     * @param item2 The second name of Item
     * @return returns 1 if item1's review count is <= item2's review count,
     * returns -1 if item1's review count is >= item2's review count,
     * returns 0 otherwise
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
