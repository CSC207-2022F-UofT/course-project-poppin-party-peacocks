package Entities;

import java.util.ArrayList;

/**
 * An interface that specifies the functionalities expected from a list of product lists
 */
public interface ListOfProductLists {
    /** returns the list of ProductList*/
    ArrayList<ProductList> getListOfWishlist();
    /** add ProductList to the listOfProductList*/
    void addWishlist(ProductList wishlist);
    /** remove ProductList to the listOfProductList*/
    void removeWishlist(ProductList productList);
    /** returns the index by the name of the ProductList*/
    int getIndexByName(String name);
    /** sets the ProductList at a desired index*/
    void setWishlist(int index, ProductList wl);
    /** returns the name of the ProductList*/
    ArrayList<String> getWishlistNames();
}
