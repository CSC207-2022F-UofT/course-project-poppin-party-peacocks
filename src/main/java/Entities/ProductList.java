package Entities;

import java.util.ArrayList;
import java.util.Date;


/**
 * An interface that specifies functionalities expected from a list of products
 */
public interface ProductList {
    /** returns the name of the ProductList or DisplayList*/
    String getName();
    /** returns the ProductList itself*/
    ArrayList<Product> getProductList();
    /** returns the DisplayedList itself*/
    ArrayList<Product> getDisplayedList();
    /** returns the added date of the ProductList or DisplayList*/
    Date getDateAdded();
    /** returns the length of the ProductList or DisplayList*/
    int getListSize();
    /** sets a new added date for the ProductList or DisplayList*/
    void setDateAdded(Date date);
    /** sets a new name for the ProductList or DisplayList*/
    void setName(String name);
    /** adds a Product to ProductList and DisplayList*/
    boolean addProduct(Product product);
    /** removes a Product from ProductList and DisplayList*/
    boolean removeProduct(Product product);
}
