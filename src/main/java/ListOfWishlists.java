import java.util.*;

public class ListOfWishlists {

    ArrayList<Wishlist> listWishlist;
    
    public ListOfWishlists(ArrayList<Wishlist> wishlists){
        this.listWishlist = wishlists;
    }

    public void addWishlist(Wishlist wishlist){
        this.listWishlist.add(wishlist);
    }

}
