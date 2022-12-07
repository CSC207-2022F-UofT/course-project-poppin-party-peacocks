package Entities;
import java.util.*;

public class ListOfWishlists implements ListOfProductLists {

    private ArrayList<ProductList> listWishlist;

    public ListOfWishlists(){
        this.listWishlist = new ArrayList<ProductList>();
    }

    public ListOfWishlists(ArrayList<ProductList> wishlists){
        this.listWishlist = wishlists;
    }

    public ArrayList<ProductList> getListOfWishlist() {
        return this.listWishlist;
    }


    public void addWishlist(ProductList wishlist){
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
