package Entities;
import java.util.Comparator;

public class ItemReviewStarComparator implements Comparator<Product> {

    /**
     * Takes 2 Items and compares their review stars using .getReviewStar()
     * Returns 1, -1, 0 depending on the results of the comparison
     * Default saved comparison: Highest to Lowest (descending)
     * @param item1 The first name of Entities.Item
     * @param item2 The second name of Entities.Item
     * @return returns 1 if item1's review star is <= item2's review star,
     * returns -1 if item1's review star is >= item2's review star,
     * returns 0 otherwise
     */
    @Override
    public int compare(Product item1, Product item2) {
        return Double.compare(item2.getReviewStars(), item1.getReviewStars());
    }
}
