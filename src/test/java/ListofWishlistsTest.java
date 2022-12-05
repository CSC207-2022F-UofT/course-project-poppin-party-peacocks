import Entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ListofWishlistsTest {
    ProductList christmasWishlist = new Wishlist("Christmas Wishlist");

    ProductList birthdayWishlist = new Wishlist("Christmas Wishlist");

    ListofProductLists listofProductLists = new ListOfWishlists();





    ///////////////////////////////
    //testing getters and setters//
    ///////////////////////////////

    @Test
    public void getsetWishListTest() {
        listofProductLists.addWishlist(christmasWishlist);
        ArrayList<ProductList> testwishListList = new ArrayList<>();
        testwishListList.add(christmasWishlist);
        Assertions.assertEquals(listofProductLists.getListOfWishlist(),testwishListList);
    }


}