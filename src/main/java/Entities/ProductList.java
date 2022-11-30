package Entities;

import java.util.ArrayList;
import java.util.Date;

public interface ProductList {
    String getName();
    ArrayList<Product> getProductList();
    ArrayList<Product> getDisplayedList();
    Date getDateAdded();
    ArrayList<String> getSelectedTags();
    int getListSize();
    void setDateAdded(Date date);
    void setName(String name);
    void sortProductListByDate(String order);
    void sortProductListByName(String order);
    void sortProductListByReviewStars(String order);
    void sortProductListByReviewCount(String order);
    void sortProductListByPrice(String order);
    boolean addProduct(Product product);
    boolean removeProduct(Product product);
    void filterProductList(String[] tags);
}
