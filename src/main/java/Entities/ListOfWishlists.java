package Entities;
import java.util.*;

/**
 * a class that manages constructors for a list of Wishlists
 */
public class ListOfWishlists {

    private final ArrayList<Wishlist> listWishlist;

    public ListOfWishlists(){
        this.listWishlist = new ArrayList<>();
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

    public void removeWishlist(Wishlist wishlist){listWishlist.remove(wishlist);}
    public void setWishlist(int index, Wishlist newWishlist){
        listWishlist.set(index,newWishlist);
    }
    public int getIndexByName(String name){
        for(Wishlist wl : listWishlist){
            if (wl.getName().equals(name)){
                return listWishlist.indexOf(wl);
            }
        }
        return -1;
    }
    public ArrayList<String> getWishlistNames(){
        ArrayList<String> wishlistNames = new ArrayList<>();
        for(Wishlist w : listWishlist){
            wishlistNames.add(w.getName());
        }
        return wishlistNames;
    }
}
