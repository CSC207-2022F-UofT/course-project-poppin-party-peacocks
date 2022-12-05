package Entities;

import java.util.ArrayList;
import java.util.Date;

/**
 * An interface that specifies the functionalities expected from a list of product lists
 */
public interface ListofProductLists {
    ArrayList<ProductList> getListOfWishlist();
    void addWishlist(ProductList wishlist);
}
