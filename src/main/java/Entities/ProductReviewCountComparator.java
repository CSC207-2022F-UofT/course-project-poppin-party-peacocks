package Entities;

import UseCases.Comparator.ProductComparator;

/**
 * a class that compares 2 Products with respect to their review count
 */
public class ProductReviewCountComparator implements ProductComparator {
    /**
     * Takes 2 Items and compares their review count using .getReviewCount()
     * Returns 1, -1, 0 depending on the results of the comparison
     * Default saved comparison: Lowest to Highest (ascending)
     * @param item1 The first name of Entities.Item
     * @param item2 The second name of Entities.Item
     * @return returns 1 if item1's review count is > item2's review count,
     * returns -1 if item1's review count is < item2's review count,
     * returns 0 otherwise
     */
    @Override
    public int compare(Product item1, Product item2) {
        return Integer.compare(item1.getReviewCount(), item2.getReviewCount());
    }
}
