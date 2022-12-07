package Entities;

import UseCases.Comparator.ProductComparator;

/**
 * a class that compares 2 Products with respect to their name
 */
public class ProductNameComparator implements ProductComparator {
    /**
     * Takes 2 Items and compares their names using .getItemName()
     * Default saved comparison: A-Z (ascending)
     * @param item1 The first name of Entities.Item
     * @param item2 The second name of Entities.Item
     * @return returns 1 if item1's name is after item2's name,
     * returns -1 if item1's name is before item2's name,
     * returns 0 otherwise
     */
    @Override
    public int compare(Product item1, Product item2) {
        return (item1.getProductName().compareTo(item2.getProductName()));
    }
}
