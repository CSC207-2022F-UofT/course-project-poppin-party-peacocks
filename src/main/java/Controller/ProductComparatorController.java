package Controller;

import Entities.*;

import java.util.ArrayList;
import java.util.Collections;
import UseCases.Comparator.ProductComparator;
import UseCases.Comparator.ProductComparatorFactory;

/**
 * a controller class that uses comparator factory to create the different types of comparators used in sorting
 */
public class ProductComparatorController {
    private ArrayList<Product> displayList;

    public ProductComparatorController(ArrayList<Product> displayList) {
        this.displayList = displayList;
    }

    public ArrayList<Product> getDisplayList() {
        return displayList;
    }

    /**
     *
     * @param
     * @return
     */
    public ArrayList<Product> sortList(String order, String word) {
        ProductComparatorFactory ProductFactory = new ProductComparatorFactory();
        ProductComparator productComparator = ProductFactory.createComparator(word.toLowerCase());
        return sortingHelper(order, productComparator);
    }

    public ArrayList<Product> sortingHelper(String order, ProductComparator productComparator) {
        switch (order.toLowerCase()) {
            case "ascending":
                displayList.sort(productComparator);
                break;
            case "descending":
                displayList.sort(Collections.reverseOrder(productComparator));
                break;
            default:
                throw new IllegalArgumentException();
        }
        return null;
    }

    public void getSortedList (String order, String word) {
        ProductComparatorController displayList = new ProductComparatorController(getDisplayList());
        displayList.sortList(order, word);
    }
}
