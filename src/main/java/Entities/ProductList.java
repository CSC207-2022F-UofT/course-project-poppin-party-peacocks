package Entities;

import java.util.ArrayList;
import java.util.Date;


/**
 * An interface that specifies functionalities expected from a list of products
 */
public interface ProductList {
    String getName();
    ArrayList<Product> getProductList();
    ArrayList<Product> getDisplayedList();
    Date getDateAdded();
    int getListSize();
    void setDateAdded(Date date);
    void setName(String name);
    boolean addProduct(Product product);
    boolean removeProduct(Product product);
}
