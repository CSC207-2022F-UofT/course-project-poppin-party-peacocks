package Entities;
import java.util.*;

/**
 * A class that stores a list of products. Implements ProductList functionalities.
 */
public class Wishlist implements ProductList{
    /** field that contains the name of the Wishlist*/
    private String name;
    /** field that contains the productList as an ArrayList*/
    private final ArrayList<Product> productList;
    /** field that contains the displayedList as an ArrayList*/
    private ArrayList<Product> displayedList;
    /** field that contains added date of the Wishlist*/
    private Date dateAdded;

    public Wishlist(String name){
        this.name = name;
        this.productList = new ArrayList<>();
        this.displayedList = new ArrayList<>();
        this.dateAdded = new Date();
    }

    public Wishlist(String name, ArrayList<Product> itemList, ArrayList<Product> displayedList, Date dateAdded){
        this.name = name;
        this.productList = itemList;
        this.displayedList = displayedList;
        this.dateAdded = dateAdded;
    }

    public Wishlist (ArrayList<Product> itemList) {
        this.productList = itemList;
    }

    public String getName() { return  this.name; }
    public ArrayList<Product> getProductList() {return this.productList; }
    public ArrayList<Product> getDisplayedList() {return this.displayedList; }
    public Date getDateAdded() {return this.dateAdded; }
    /** */
    public int getListSize(){
        return productList.size();
    }
    public void setName(String name){
        this.name = name;
    }
    public void setDateAdded(Date date) { this.dateAdded = date; }

    /**
     * Adds an Entities.Item to the productList and displayedList
     * @param product The Entities.Product that the user wants to add to the ProductList
     * @return True when an Entities.Product gets added to the ProductList
     */
    public boolean addProduct(Product product){
        productList.add(product);
        displayedList.add(product);
        return true;
    }

    /**
     * Removes an Entities.Item from the productList
     * @param product The Entities.Product the user wants to delete from the ProductList
     * @return True when an Entities.Product gets removed from the ProductList
     */
    public boolean removeProduct(Product product){
        productList.remove(product);
        displayedList.remove(product);
        return true;
    }

    /**
     * replaces a product in the wishlist with a new product that has the same name. Used for saving to DataBase.
     * @param productName the name of the product to replace
     * @param newProduct the new product to replace with
     */
    public void setProduct(String productName, Product newProduct){
        int productListIndex = 0;
        int displayedListIndex = 0;
        for (Product p : productList) {
            if (Objects.equals(p.getProductName(), productName)) {
                productListIndex = productList.indexOf(p);
            }
        }
        for (Product p : displayedList) {
            if (Objects.equals(p.getProductName(), productName)) {
                displayedListIndex = displayedList.indexOf(p);
            }
        }
        productList.set(productListIndex, newProduct);
        displayedList.set(displayedListIndex, newProduct);
    }
}
