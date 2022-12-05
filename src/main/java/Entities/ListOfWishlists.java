package Entities;
import java.util.*;

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

    public void removeWishlist(String wishlistName){
        listWishlist.removeIf(w -> Objects.equals(w.getName(), wishlistName));
    }
    public ArrayList<String> getWishlistNames(){
        ArrayList<String> wishlistNames = new ArrayList<>();
        for(Wishlist w : listWishlist){
            wishlistNames.add(w.getName());
        }
        return wishlistNames;
    }
}
