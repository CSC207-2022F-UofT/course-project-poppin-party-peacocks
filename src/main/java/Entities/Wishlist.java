package Entities;
import java.util.*;

/**
 * A class that stores a list of products. Implements ProductList functionalities.
 */
public class Wishlist implements ProductList{
    private String name;
    private final ArrayList<Product> productList;
    private ArrayList<Product> displayedList;
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

    @Override
    public Collection<Object> getSelectedTags() {
        return null;
    }
}
