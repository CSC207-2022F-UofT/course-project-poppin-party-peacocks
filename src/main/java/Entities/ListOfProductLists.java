package Entities;

import java.util.ArrayList;

/**
 * An interface that specifies the functionalities expected from a list of product lists
 */
public interface ListOfProductLists {
    ArrayList<ProductList> getListOfWishlist();
    void addWishlist(ProductList wishlist);

    void removeWishlist(ProductList productList);

    int getIndexByName(String name);

    void setWishlist(int index, ProductList wl);

    ArrayList<String> getWishlistNames();
}
