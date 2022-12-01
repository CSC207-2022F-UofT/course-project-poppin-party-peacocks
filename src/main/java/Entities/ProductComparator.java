package Entities;

import java.util.Comparator;

public interface ProductComparator extends Comparator<Product> {
    int compare(Product item1, Product item2);
}
