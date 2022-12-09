package UseCases.Comparator;

import Entities.Product;

import java.util.Comparator;

/**
 * An interface that has a method that compares two Products.
 */
public interface ProductComparator extends Comparator<Product> {
    /**a compare method that compares two Products; item1 and item2 */
    int compare(Product item1, Product item2);
}
