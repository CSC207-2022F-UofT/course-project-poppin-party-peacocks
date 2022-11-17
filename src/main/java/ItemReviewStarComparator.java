import java.util.Comparator;
public class ItemReviewStarComparator implements Comparator<Item> {

    /**
     * Takes 2 Items and compares their review stars using .getReviewStar()
     * Returns 1, -1, 0 depending on the results of the comparison
     * Default saved comparison: Highest to Lowest (descending)
     * @param item1 The first name of Item
     * @param item2 The second name of Item
     * @return returns 1 if item1's review star is <= item2's review star,
     * returns -1 if item1's review star is >= item2's review star,
     * returns 0 otherwise
     */
    @Override
    public int compare(Item item1, Item item2) {
        if (item1.getReviewStars() <= item2.getReviewStars()) {
            return 1;
        } else if (item1.getReviewStars() >= item2.getReviewStars()) {
            return -1;
        } else {
            return 0;
        }
    }
}
