package Controller;

import Entities.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import UseCases.Comparator.ProductComparator;
import UseCases.Comparator.ProductComparatorFactory;

/**
 * a controller class that uses comparator factory to create the different types of comparators
 * and sorts the wishlist using that comparator
 */
public class ProductComparatorController implements ProductList {
    private String name;
    private final ArrayList<Product> productList;
    private final ArrayList<Product> displayedList;
    private Date dateAdded;
    private final ArrayList<String> selectedTags;

    public ProductComparatorController(String name){
        this.name = name;
        this.productList = new ArrayList<>();
        this.displayedList = new ArrayList<>();
        this.dateAdded = new Date();
        this.selectedTags = new ArrayList<>();
    }

    /**
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
                productList.sort(productComparator);
                break;
            case "descending":
                productList.sort(Collections.reverseOrder(productComparator));
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Product> getProductList() {
        return this.productList;
    }

    public ArrayList<Product> getDisplayedList() {
        return this.displayedList;
    }

    public Date getDateAdded() {
        return this.dateAdded;
    }

    public ArrayList<String> getSelectedTags() {
        return this.selectedTags;
    }

    public int getListSize() {
        return productList.size();
    }

    public void setDateAdded(Date date) {
        this.dateAdded = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Adding an Entities.Item to the itemList
     * @param product the Product that the user wants to add to the itemList
     * @return True when a Product gets added to the itemList
     */
    public boolean addProduct(Product product) {
        productList.add(product);
        displayedList.add(product);
        return false;
    }

    /**
     * Removing an Entities.Item from the ProductList
     * @param product the Product the user wants to delete from the itemList
     * @return True when a Product gets removed from the itemList
     */
    public boolean removeProduct(Product product) {
        return false;
    }
}
