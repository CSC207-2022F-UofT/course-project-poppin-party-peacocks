import java.util.Comparator;
public class ItemReviewStarComparator implements Comparator<Item> {
    // compares two items by their review star
    // L-H as default
    /**
     * Takes 2 Items and compares their review stars using .getReviewStar() and sorts in descending order (highest-lowest)
     *
     * @param item1 The first name of Item
     * @param item2 The second name of Item
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
