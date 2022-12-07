package UseCases.Comparator;

import Entities.Product;

import java.util.Comparator;

/**
 * An interface that has a method that compares two Products.
 */
public interface ProductComparator extends Comparator<Product> {
    int compare(Product item1, Product item2);
}
