package Entities;
import java.util.*;

/**
 * a class that manages constructors for a list of Wishlists
 */
public class ListOfWishlists implements ListOfProductLists {
    /** field that contains the listOfWishList*/
    private final ArrayList<ProductList> listWishlist;

    public ListOfWishlists(){
        this.listWishlist = new ArrayList<>();
    }

    public ListOfWishlists(ArrayList<ProductList> wishlists){
        this.listWishlist = wishlists;
    }
    /** returns the listOfWishList*/
    public ArrayList<ProductList> getListOfWishlist() {
        return this.listWishlist;
    }
    /** adds wishlist to the listOfWishList*/
    public void addWishlist(ProductList wishlist){
        this.listWishlist.add(wishlist);
    }
    /**
     * removes the wishlist from the listOfWishlist
     * @param wishlist a wishlist the user and inputted
     */
    public void removeWishlist(ProductList wishlist){listWishlist.remove(wishlist);}
    /**
     * removes the wishList by its name from the listOfWishList
     * @param name of the wishlist that the user wants to remove
     */
    public void removeWishlistByName(String name){

        for (ProductList wishlist: listWishlist){
            if (wishlist.getName().equals(name)){
                listWishlist.remove(wishlist);
                break;
            }
        }
    }
    /**
     * sets the wishlist to the listOfWishList at the user's specified index and replaces the old wishlist at said index
     * @param index of where the user wants to set the wishlist at
     * @param newWishlist the wishlist the user set into the listOfWishList
     */
    public void setWishlist(int index, ProductList newWishlist){
        listWishlist.set(index,newWishlist);
    }
    /**
     * returns the index by the name of the wishlist
     * @param name of the wishlist
     * @return index of the name of the wishlist or -1 for the wishlist does not exist in the listOfWishList
     */
    public int getIndexByName(String name){
        for(ProductList wl : listWishlist){
            if (wl.getName().equals(name)){
                return listWishlist.indexOf(wl);
            }
        }
        return -1;
    }
    /**
     * returns an ArrayList of strings of the names of the wishlist in the listOfWishList
     * @return an ArrayList of strings of the names of the wishlist in the listOfWishList
     */
    public ArrayList<String> getWishlistNames(){
        ArrayList<String> wishlistNames = new ArrayList<>();
        for(ProductList w : listWishlist){
            wishlistNames.add(w.getName());
        }
        return wishlistNames;
    }
}
