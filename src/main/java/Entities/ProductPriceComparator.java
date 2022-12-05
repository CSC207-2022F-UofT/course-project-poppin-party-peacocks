package Entities;

import UseCases.Comparator.ProductComparator;

/**
 * a class that compares 2 Products with respect to their price
 */
public class ProductPriceComparator implements ProductComparator {
    /**
     * Takes 2 Items and compares their prices using .getItemPrice()
     * Defauly saved comparison: Lowest to Highest (ascending)
     * @param item1 The first name of Entities.Item
     * @param item2 The second name of Entities.Item
     * @return returns 1 if item1's price > item2's price,
     * returns -1 if item1's price < item2's price,
     * returns 0 otherwise
     */
    @Override
    public int compare(Product item1, Product item2) {
        return Double.compare(item1.getProductPrice(), item2.getProductPrice());
    }
}
