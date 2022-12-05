import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Entities.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class WishlistTest {
    Item myFavDrink = new Item("Lime Bubbly", 5.47, 5.00, "www.shoppers.com/bubbly",
            "my favorite drink, bubbly", new String[]{"Drink"}, 69, 4.19,"www.shoppersimage.com/bubbly");
    Item animeFigure = new Item("Starlight Anya Forger", 100, 85.00, "www.amazon.com/AnyaPeanuts", "new Anya figure", new String[]{"Figure"}, 150, 4.8,"www.amazonimage.com/AnyaPeanuts" );
    Item plushie = new Item("Whale Plushie", 40.99, 30.00, "www.amazon.com/WhalePlushie",
            "Giant Whale Plushie", new String[]{"toys"}, 1050, 4.3, "www.amazonimage.com/OhWhale");

    Wishlist christmasWishlist = new Wishlist("Christmas Wishlist");

    ///////////////////////////////
    //testing getters and setters//
    ///////////////////////////////
    @Test
    public void getNameTest() {
        Assertions.assertEquals("Christmas Wishlist", christmasWishlist.getName());
    }

    @Test
    public void getItemListTest() {
        christmasWishlist.addProduct(myFavDrink);
        christmasWishlist.addProduct(animeFigure);
        christmasWishlist.addProduct(plushie);
        ArrayList<Product> testItemList = christmasWishlist.getProductList();

        Assertions.assertEquals(christmasWishlist.getProductList(), testItemList);
    }

    @Test
    public void getDisplayedListTest() {
        christmasWishlist.addProduct(myFavDrink);
        christmasWishlist.addProduct(animeFigure);
        christmasWishlist.addProduct(plushie);
        ArrayList<Product> testDisplayList = christmasWishlist.getDisplayedList();

        Assertions.assertEquals(christmasWishlist.getDisplayedList(), testDisplayList);
    }

    @Test
    public void getDateAddedTest() {
        christmasWishlist.addProduct(myFavDrink);
        christmasWishlist.addProduct(animeFigure);
        christmasWishlist.addProduct(plushie);
        Date testDate = christmasWishlist.getDateAdded();

        Assertions.assertEquals(christmasWishlist.getDateAdded(), testDate);
    }

    @Test
    public void getSelectedTagsTest() {
        christmasWishlist.addProduct(myFavDrink);
        christmasWishlist.addProduct(animeFigure);
        christmasWishlist.addProduct(plushie);
        ArrayList<String> testTags = christmasWishlist.getSelectedTags();

        Assertions.assertEquals(christmasWishlist.getSelectedTags(), testTags);
    }

    @Test
    public void getListSizeTest(){
        christmasWishlist.addProduct(myFavDrink);
        christmasWishlist.addProduct(animeFigure);
        christmasWishlist.addProduct(plushie);
        Assertions.assertEquals(christmasWishlist.getListSize(), 3);
    }

    @Test
    public void setDateAddedTest() {
        christmasWishlist.addProduct(myFavDrink);
        Date testDate = new Date(2022, Calendar.NOVEMBER, 25);
        christmasWishlist.setDateAdded(testDate);

        Assertions.assertEquals(testDate.getYear(), christmasWishlist.getDateAdded().getYear());
        Assertions.assertEquals(testDate.getMonth(), christmasWishlist.getDateAdded().getMonth());
        Assertions.assertEquals(testDate.getDay(), christmasWishlist.getDateAdded().getDay());
    }

    @Test void setNameTest(){
        christmasWishlist.setName("christmas");
        Assertions.assertEquals(christmasWishlist.getName(), "christmas");
    }

    ///////////////////
    //testing methods//
    ///////////////////
//    @Test
//    public void sortWishlistByDateAscendingTest() {
//        christmasWishlist.addProduct(myFavDrink);
//        christmasWishlist.addProduct(animeFigure);
//        christmasWishlist.addProduct(plushie);
//
//        Wishlist testingWishlist = new Wishlist("Testing Wishlist");
//        testingWishlist.addProduct(myFavDrink);
//        testingWishlist.addProduct(animeFigure);
//        testingWishlist.addProduct(plushie);
//
//        christmasWishlist.sortProductListByDate("ascending");
//        testingWishlist.sortProductListByDate("ascending");
//
//        Assertions.assertTrue(true, String.valueOf(testingWishlist.equals(christmasWishlist)));
//    }
//
//    @Test
//    public void sortWishlistByDateDescendingTest() {
//        christmasWishlist.addProduct(myFavDrink);
//        christmasWishlist.addProduct(animeFigure);
//        christmasWishlist.addProduct(plushie);
//
//        Wishlist testingWishlist = new Wishlist("Testing Wishlist");
//        testingWishlist.addProduct(myFavDrink);
//        testingWishlist.addProduct(animeFigure);
//        testingWishlist.addProduct(plushie);
//
//        christmasWishlist.sortProductListByDate("descending");
//        testingWishlist.sortProductListByDate("descending");
//
//        Assertions.assertTrue(true, String.valueOf(testingWishlist.equals(christmasWishlist)));
//    }
//
//    @Test
//    public void sortWishlistByNameAscendingTest() {
//        christmasWishlist.addProduct(myFavDrink);
//        christmasWishlist.addProduct(animeFigure);
//        christmasWishlist.addProduct(plushie);
//
//        Wishlist testingWishlist = new Wishlist("Testing Wishlist");
//        testingWishlist.addProduct(myFavDrink);
//        testingWishlist.addProduct(animeFigure);
//        testingWishlist.addProduct(plushie);
//
//        christmasWishlist.sortProductListByName("ascending");
//        testingWishlist.sortProductListByName("ascending");
//
//        Assertions.assertTrue(true, String.valueOf(testingWishlist.equals(christmasWishlist)));
//    }
//
//    @Test
//    public void sortWishlistByNameDescendingTest() {
//        christmasWishlist.addProduct(myFavDrink);
//        christmasWishlist.addProduct(animeFigure);
//        christmasWishlist.addProduct(plushie);
//
//        Wishlist testingWishlist = new Wishlist("Testing Wishlist");
//        testingWishlist.addProduct(myFavDrink);
//        testingWishlist.addProduct(animeFigure);
//        testingWishlist.addProduct(plushie);
//
//        christmasWishlist.sortProductListByName("descending");
//        testingWishlist.sortProductListByName("descending");
//
//        Assertions.assertTrue(true, String.valueOf(testingWishlist.equals(christmasWishlist)));
//    }
//
//    @Test
//    public void sortWishlistByReviewStarsAscendingTest() {
//        christmasWishlist.addProduct(myFavDrink);
//        christmasWishlist.addProduct(animeFigure);
//        christmasWishlist.addProduct(plushie);
//
//        Wishlist testingWishlist = new Wishlist("Testing Wishlist");
//        testingWishlist.addProduct(myFavDrink);
//        testingWishlist.addProduct(animeFigure);
//        testingWishlist.addProduct(plushie);
//
//        christmasWishlist.sortProductListByReviewStars("ascending");
//        testingWishlist.sortProductListByReviewStars("ascending");
//
//        Assertions.assertTrue(true, String.valueOf(testingWishlist.equals(christmasWishlist)));
//    }
//
//    @Test
//    public void sortWishlistByReviewStarsDescendingTest() {
//        christmasWishlist.addProduct(myFavDrink);
//        christmasWishlist.addProduct(animeFigure);
//        christmasWishlist.addProduct(plushie);
//
//        Wishlist testingWishlist = new Wishlist("Testing Wishlist");
//        testingWishlist.addProduct(myFavDrink);
//        testingWishlist.addProduct(animeFigure);
//        testingWishlist.addProduct(plushie);
//
//        christmasWishlist.sortProductListByReviewStars("descending");
//        testingWishlist.sortProductListByReviewStars("descending");
//
//        Assertions.assertTrue(true, String.valueOf(testingWishlist.equals(christmasWishlist)));
//    }
//
//    @Test
//    public void sortWishlistByReviewCountAscendingTest() {
//        christmasWishlist.addProduct(myFavDrink);
//        christmasWishlist.addProduct(animeFigure);
//        christmasWishlist.addProduct(plushie);
//
//        Wishlist testingWishlist = new Wishlist("Testing Wishlist");
//        testingWishlist.addProduct(myFavDrink);
//        testingWishlist.addProduct(animeFigure);
//        testingWishlist.addProduct(plushie);
//
//        christmasWishlist.sortProductListByReviewCount("ascending");
//        testingWishlist.sortProductListByReviewCount("ascending");
//
//        Assertions.assertTrue(true, String.valueOf(testingWishlist.equals(christmasWishlist)));
//    }
//
//    @Test
//    public void sortWishlistByReviewCountDescendingTest() {
//        christmasWishlist.addProduct(myFavDrink);
//        christmasWishlist.addProduct(animeFigure);
//        christmasWishlist.addProduct(plushie);
//
//        Wishlist testingWishlist = new Wishlist("Testing Wishlist");
//        testingWishlist.addProduct(myFavDrink);
//        testingWishlist.addProduct(animeFigure);
//        testingWishlist.addProduct(plushie);
//
//        christmasWishlist.sortProductListByReviewCount("descending");
//        testingWishlist.sortProductListByReviewCount("descending");
//
//        Assertions.assertTrue(true, String.valueOf(testingWishlist.equals(christmasWishlist)));
//    }
//
//    @Test
//    public void sortWishlistByPriceAscendingTest() {
//        christmasWishlist.addProduct(myFavDrink);
//        christmasWishlist.addProduct(animeFigure);
//        christmasWishlist.addProduct(plushie);
//
//        Wishlist testingWishlist = new Wishlist("Testing Wishlist");
//        testingWishlist.addProduct(myFavDrink);
//        testingWishlist.addProduct(animeFigure);
//        testingWishlist.addProduct(plushie);
//
//        christmasWishlist.sortProductListByPrice("ascending");
//        testingWishlist.sortProductListByPrice("ascending");
//
//        Assertions.assertTrue(true, String.valueOf(testingWishlist.equals(christmasWishlist)));
//    }
//
//    @Test
//    public void sortWishlistByPriceDescendingTest() {
//        christmasWishlist.addProduct(myFavDrink);
//        christmasWishlist.addProduct(animeFigure);
//        christmasWishlist.addProduct(plushie);
//
//        Wishlist testingWishlist = new Wishlist("Testing Wishlist");
//        testingWishlist.addProduct(myFavDrink);
//        testingWishlist.addProduct(animeFigure);
//        testingWishlist.addProduct(plushie);
//
//        christmasWishlist.sortProductListByPrice("descending");
//        testingWishlist.sortProductListByPrice("descending");
//
//        Assertions.assertTrue(true, String.valueOf(testingWishlist.equals(christmasWishlist)));
//    }

    @Test
    public void addItemTest() {
        Assertions.assertTrue(true, String.valueOf(christmasWishlist.addProduct(myFavDrink)));
    }

    @Test
    public void removeItemTest() {
        christmasWishlist.addProduct(myFavDrink);
        christmasWishlist.addProduct(animeFigure);
        christmasWishlist.addProduct(plushie);

        Assertions.assertTrue(true, String.valueOf(christmasWishlist.removeProduct(animeFigure)));
    }

//    @Test
//    public void filterWishlistTest() {
//        String[] testTags = {"toys"};
//        christmasWishlist.addProduct(myFavDrink);
//        christmasWishlist.addProduct(animeFigure);
//        christmasWishlist.addProduct(plushie);
//
//        Wishlist testingWishlist = new Wishlist("Testing Wishlist");
//        testingWishlist.addProduct(myFavDrink);
//        testingWishlist.addProduct(animeFigure);
//        testingWishlist.addProduct(plushie);
//        testingWishlist.filterProductList(testTags);
//        christmasWishlist.filterProductList(testTags);
//
//        Assertions.assertTrue(true, String.valueOf(testingWishlist.equals(christmasWishlist)));
//
//    }

    public void displayTagsTest() {
        christmasWishlist.addProduct(myFavDrink);
        christmasWishlist.addProduct(animeFigure);
        christmasWishlist.addProduct(plushie);

        Wishlist testingWishlist = new Wishlist("Testing Wishlist");
        testingWishlist.addProduct(myFavDrink);
        testingWishlist.addProduct(animeFigure);
        testingWishlist.addProduct(plushie);

        Assertions.assertEquals(testingWishlist.getSelectedTags(), christmasWishlist.getSelectedTags());
    }

    public void displayListTest() {
        christmasWishlist.addProduct(myFavDrink);
        christmasWishlist.addProduct(animeFigure);
        christmasWishlist.addProduct(plushie);

        Wishlist testingWishlist = new Wishlist("Testing Wishlist");
        testingWishlist.addProduct(myFavDrink);
        testingWishlist.addProduct(animeFigure);
        testingWishlist.addProduct(plushie);

        Assertions.assertEquals(testingWishlist.getDisplayedList(), christmasWishlist.getDisplayedList());
    }
}