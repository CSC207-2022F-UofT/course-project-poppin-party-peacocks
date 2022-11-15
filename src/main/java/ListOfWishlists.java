import java.util.*;

public class ListOfWishlists {

    ArrayList<Wishlist> listWishlist;
    public ListOfWishlists(){
        this.listWishlist = new ArrayList<Wishlist>();
    }

    public void addWishlist(Wishlist wishlist){
        this.listWishlist.add(wishlist);
    }

}
