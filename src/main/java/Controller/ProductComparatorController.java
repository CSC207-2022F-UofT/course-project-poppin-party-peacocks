package Controller;

import Entities.*;

import java.util.Collections;

import UseCases.Comparator.ProductComparator;
import UseCases.Comparator.ProductComparatorFactory;

/**
 * a controller class that uses comparator factory to create the different types of comparators
 * and sorts the wishlist using that comparator
 */
public class ProductComparatorController {
    /** field that contains the productList that we would like to use*/
    private final ProductList productList;

    /**constructor*/
    public ProductComparatorController(ProductList wishlist){
        this.productList = wishlist;
    }

    /**
     * the main method that we use to sort productList. creates a factory, then a corresponding comparator, then sorts
     * using order and said comparator
     * @param order the String the user wants to sort by; "ascending" or "descending"
     * @param word the name of the productComparator the user wants to make;
     *             "name", "price", "date", "review count", "review star"
     */
    public void sortList(String order, String word) {
        ProductComparatorFactory ProductFactory = new ProductComparatorFactory();
        ProductComparator productComparator = ProductFactory.createComparator(word.toLowerCase());
        sortingHelper(order, productComparator);
    }

    /**
     * helper method for sortList. takes a string sorting order and a productComparator and sorts the list
     * @param order the String the user wants to sort by; "ascending" or "descending"
     * @param productComparator a comparator that the user wants to compare with
     */
    public void sortingHelper(String order, ProductComparator productComparator) {
        switch (order.toLowerCase()) {
            case "ascending":
                this.productList.getDisplayedList().sort(productComparator);
                break;
            case "descending":
                this.productList.getDisplayedList().sort(Collections.reverseOrder(productComparator));
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
}
