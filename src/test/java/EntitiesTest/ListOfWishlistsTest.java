package EntitiesTest;

import Entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ListOfWishlistsTest {
    ProductList christmasWishlist = new Wishlist("Christmas Wishlist");
    ProductList birthdayWishlist = new Wishlist("Birthday Wishlist");

    ListOfProductLists listofProductLists = new ListOfWishlists();

    @Test
    public void getsetWishListTest() {
        listofProductLists.addWishlist(christmasWishlist);
        ArrayList<ProductList> testwishListList = new ArrayList<>();
        testwishListList.add(christmasWishlist);
        Assertions.assertEquals(listofProductLists.getListOfWishlist(),testwishListList);
    }

    @Test
    public void addWishlistTest () {
        listofProductLists.addWishlist(christmasWishlist);
        listofProductLists.addWishlist(birthdayWishlist);

        Assertions.assertEquals(listofProductLists.getListOfWishlist().get(0), christmasWishlist);
        Assertions.assertEquals(listofProductLists.getListOfWishlist().get(1), birthdayWishlist);

    }

    @Test
    public void setWishlistTest () {
        ProductList testWishlist = new Wishlist("Test Wishlist1");

        listofProductLists.addWishlist(testWishlist);
        listofProductLists.addWishlist(testWishlist);
        listofProductLists.setWishlist(0, birthdayWishlist);
        listofProductLists.setWishlist(1, christmasWishlist);

        ArrayList<ProductList> correctList = new ArrayList<>();
        correctList.add(testWishlist);
        correctList.add(testWishlist);
        correctList.set(0, birthdayWishlist);
        correctList.set(1, christmasWishlist);

        Assertions.assertEquals(listofProductLists.getListOfWishlist().get(0), correctList.get(0));
        Assertions.assertEquals(listofProductLists.getListOfWishlist().get(1), correctList.get(1));
    }

    @Test
    public void getIndexByNamePassTest () {
        int christmasWishlistIndex = 0;
        int birthdayWishlistIndex = 1;

        listofProductLists.addWishlist(christmasWishlist);
        listofProductLists.addWishlist(birthdayWishlist);

        Assertions.assertEquals(listofProductLists.getIndexByName("Christmas Wishlist"), christmasWishlistIndex);
        Assertions.assertEquals(listofProductLists.getIndexByName("Birthday Wishlist"), birthdayWishlistIndex);
    }

    @Test
    public void getIndexByNameFailTest () {
        int indexValue = -1;

        listofProductLists.addWishlist(christmasWishlist);
        listofProductLists.addWishlist(birthdayWishlist);

        Assertions.assertEquals(listofProductLists.getIndexByName("Hermanns's Starlight Reveluv Wishlist"), indexValue);
    }

    @Test
    public void getWishlistNamesTest () {
        listofProductLists.addWishlist(christmasWishlist);
        listofProductLists.addWishlist(birthdayWishlist);

        ArrayList<String> listOfNames = new ArrayList<>();
        listOfNames.add("Christmas Wishlist");
        listOfNames.add("Birthday Wishlist");

        Assertions.assertEquals(listofProductLists.getWishlistNames(), listOfNames);
    }

    @Test
    public void removeWishlistTest () {
        listofProductLists.addWishlist(christmasWishlist);
        listofProductLists.addWishlist(birthdayWishlist);

        ArrayList<ProductList> correctList = new ArrayList<>();
        correctList.add(birthdayWishlist);

        listofProductLists.removeWishlist(christmasWishlist);

        Assertions.assertEquals(listofProductLists.getListOfWishlist(), correctList);
    }

    @Test
    public void removeWishlistByNameTest () {
        listofProductLists.addWishlist(christmasWishlist);
        listofProductLists.addWishlist(birthdayWishlist);

        ArrayList<ProductList> correctList = new ArrayList<>();
        correctList.add(christmasWishlist);

        listofProductLists.removeWishlistByName("Birthday Wishlist");

        Assertions.assertEquals(listofProductLists.getListOfWishlist(), correctList);
    }
}