package Entities;

import UseCases.Comparator.ProductComparator;

/**
 * a class that compares 2 Products with respect to their review stars
 */
public class ProductReviewStarComparator implements ProductComparator {

    /**
     * Takes 2 Items and compares their review stars using .getReviewStar()
     * Returns 1, -1, 0 depending on the results of the comparison
     * Default saved comparison: Lowest to Highest (ascending)
     * @param item1 The first name of Entities.Item
     * @param item2 The second name of Entities.Item
     * @return returns 1 if item1's review star is >= item2's review star,
     * returns -1 if item1's review star is <= item2's review star,
     * returns 0 otherwise
     */
    @Override
    public int compare(Product item1, Product item2) {
        if (item1.getReviewStars() >= item2.getReviewStars()) {
            return 1;
        } else if (item1.getReviewStars() <= item2.getReviewStars()) {
            return -1;
        } else {
            return 0;
        }
    }
}
