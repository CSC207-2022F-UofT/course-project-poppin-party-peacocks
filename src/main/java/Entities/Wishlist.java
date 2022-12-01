package Entities;
import java.util.*;

/**
 * A class that stores a list of products. Implements ProductList functionalities.
 */
public class Wishlist implements ProductList{
    private String name;
    private ArrayList<Product> itemList;
    private ArrayList<Product> displayedList;
    private Date dateAdded;
    private ArrayList<String> selectedTags;

    public Wishlist(String name){
        this.name = name;
        this.itemList = new ArrayList<>();
        this.displayedList = new ArrayList<>();
        this.dateAdded = new Date();
        this.selectedTags = new ArrayList<>();
    }

    public Wishlist(String name, ArrayList<Product> itemList, ArrayList<Product> displayedList, Date dateAdded, ArrayList<String> selectedTags){
        this.name = name;
        this.itemList = itemList;
        this.displayedList = displayedList;
        this.dateAdded = dateAdded;
        this.selectedTags = selectedTags;
    }

    public String getName() { return  this.name; }
    public ArrayList<Product> getProductList() {return this.itemList; }
    public ArrayList<Product> getDisplayedList() {return this.displayedList; }
    public Date getDateAdded() {return this.dateAdded; }
    public ArrayList<String> getSelectedTags() {return this.selectedTags; }
    public int getListSize(){
        return itemList.size();
    }
    public void setName(String name){
        this.name = name;
    }
    public void setDateAdded(Date date) { this.dateAdded = date; }

    /**
     * Sorts ProductList by date in added date (earliest date-latest date) or (latest date-earliest date)
     * @param order The value of string whether the user wants the ProductList to be ascending or descending
     */
    public void sortProductListByDate(String order){
        ProductComparatorFactory ProductFactory = new ProductComparatorFactory();
        ProductComparator productDateComparator = ProductFactory.createComparator("date");

        sortingHelper(order, productDateComparator);
    }

    /**
     * Sorts ProductList by name in ascending order (A-Z) or descending order (Z-A)
     * @param order The value of string whether the user wants the ProductList to be ascending or descending
     */
    public void sortProductListByName(String order) {
        ProductComparatorFactory ProductFactory = new ProductComparatorFactory();
        ProductComparator productNameComparator = ProductFactory.createComparator("name");

        sortingHelper(order, productNameComparator);
    }

    /**
     * Sorts ProductList by review stars in ascending order (lowest-highest) or descending order (highest-lowest)
     * @param order The value of string whether the user wants the ProductList to be ascending or descending
     */
    public void sortProductListByReviewStars(String order) {
        ProductComparatorFactory ProductFactory = new ProductComparatorFactory();
        ProductComparator productReviewStarComparator = ProductFactory.createComparator("review star");

        sortingHelper(order, productReviewStarComparator);
    }

    /**
     * Sorts ProductList by review count in ascending order (lowest-highest) or descending order (highest-lowest)
     * @param order The value of string whether the user wants the ProductList to be ascending or descending
     */
    public void sortProductListByReviewCount(String order) {
        ProductComparatorFactory ProductFactory = new ProductComparatorFactory();
        ProductComparator productReviewStarComparator = ProductFactory.createComparator("review count");

        sortingHelper(order, productReviewStarComparator);
    }

    /**
     * Sorts ProductList by price in ascending order (lowest-highest) or descending order (highest-lowest)
     * @param order The value of string whether the user wants the ProductList to be ascending or descending
     */
    public void sortProductListByPrice(String order) {
        ProductComparatorFactory ProductFactory = new ProductComparatorFactory();
        ProductComparator productPriceComparator = ProductFactory.createComparator("price");

        sortingHelper(order, productPriceComparator);
    }

    private void sortingHelper(String order, ProductComparator productPriceComparator) {
        switch (order.toLowerCase()) {
            case "ascending":
                displayedList.sort(productPriceComparator);
                break;
            case "descending":
                displayedList.sort(Collections.reverseOrder(productPriceComparator));
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * Adding an Entities.Item to the ProductList
     * @param product The Entities.Product that the user wants to add to the ProductList
     * @return True when an Entities.Product gets added to the ProductList
     */
    public boolean addProduct(Product product){
        itemList.add(product);
        displayedList.add(product);
        sortProductListByDate("ascending");
        return true;
    }

    /**
     * Removing an Entities.Item from the ProductList
     * @param product The Entities.Product the user wants to delete from the ProductList
     * @return True when an Entities.Product gets removed from the ProductList
     */
    public boolean removeProduct(Product product){
        itemList.remove(product);
        return true;
    }

    /**
     * Filters ProductList by tag
     * @param tags The value of sets of strings of tags
     */
    public void filterProductList(String[] tags){
        selectedTags.addAll(Arrays.asList(tags));
        displayedList = new ArrayList<>(itemList);
        ArrayList<Product> tempList = new ArrayList<>(itemList);
        for(Product i : displayedList){
            for(String tag : tags){
                ArrayList<String> iTags = new ArrayList<>(Arrays.asList(i.getTags()));
                if(!iTags.contains(tag)){
                    tempList.remove(i);
                }
            }
        }
        displayedList = tempList;
    }
}
