package Entities;
import java.util.*;

/**
 * a class that manages constructors for a list of Wishlists
 */
public class ListOfWishlists implements ListOfProductLists {

    private ArrayList<ProductList> listWishlist;

    public ListOfWishlists(){
        this.listWishlist = new ArrayList<>();
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

    public void removeWishlist(ProductList wishlist){listWishlist.remove(wishlist);}
    public void setWishlist(int index, ProductList newWishlist){
        listWishlist.set(index,newWishlist);
    }
    public int getIndexByName(String name){
        for(ProductList wl : listWishlist){
            if (wl.getName().equals(name)){
                return listWishlist.indexOf(wl);
            }
        }
        return -1;
    }
    public ArrayList<String> getWishlistNames(){
        ArrayList<String> wishlistNames = new ArrayList<>();
        for(ProductList w : listWishlist){
            wishlistNames.add(w.getName());
        }
        return wishlistNames;
    }
}
