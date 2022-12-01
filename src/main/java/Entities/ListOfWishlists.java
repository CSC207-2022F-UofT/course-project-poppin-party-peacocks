package Entities;
import java.util.*;

/**
 * a class that manages constructors for a list of Wishlists
 */
public class ListOfWishlists {

    private ArrayList<Wishlist> listWishlist;

    public ListOfWishlists(){
        this.listWishlist = new ArrayList<Wishlist>();
    }

    public ListOfWishlists(ArrayList<Wishlist> wishlists){
        this.listWishlist = wishlists;
    }

    public ArrayList<Wishlist> getListOfWishlist() {
        return this.listWishlist;
    }

    public void addWishlist(Wishlist wishlist){
        this.listWishlist.add(wishlist);
    }
}
