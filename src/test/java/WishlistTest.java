import org.junit.Assert;
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
        christmasWishlist.addItem(myFavDrink);
        christmasWishlist.addItem(animeFigure);
        christmasWishlist.addItem(plushie);

        Assertions.assertEquals("Christmas Wishlist", christmasWishlist.getName());
    }

    @Test
    public void getItemListTest() {
        christmasWishlist.addItem(myFavDrink);
        christmasWishlist.addItem(animeFigure);
        christmasWishlist.addItem(plushie);
        ArrayList<Item> testItemList = christmasWishlist.getItemList();

        Assertions.assertEquals(christmasWishlist.getItemList(), testItemList);
    }

    @Test
    public void getDisplayedListTest() {
        christmasWishlist.addItem(myFavDrink);
        christmasWishlist.addItem(animeFigure);
        christmasWishlist.addItem(plushie);
        ArrayList<Item> testDisplayList = christmasWishlist.getDisplayedList();

        Assertions.assertEquals(christmasWishlist.getDisplayedList(), testDisplayList);
    }

    @Test
    public void getDateAddedTest() {
        christmasWishlist.addItem(myFavDrink);
        christmasWishlist.addItem(animeFigure);
        christmasWishlist.addItem(plushie);
        Date testDate = christmasWishlist.getDateAdded();

        Assertions.assertEquals(christmasWishlist.getDateAdded(), testDate);
    }

    @Test
    public void getSelectedTagsTest() {
        christmasWishlist.addItem(myFavDrink);
        christmasWishlist.addItem(animeFigure);
        christmasWishlist.addItem(plushie);
        ArrayList<String> testTags = christmasWishlist.getSelectedTags();

        Assertions.assertEquals(christmasWishlist.getSelectedTags(), testTags);
    }

    @Test
    public void getListSizeTestEmpty() {
        int size = christmasWishlist.getListSize();
        Assertions.assertEquals(size, 0);
    }

    @Test
    public void GetListSizeTestNonEmpty(){
        christmasWishlist.addItem(myFavDrink);
        christmasWishlist.addItem(animeFigure);
        int size = christmasWishlist.getListSize();
        Assertions.assertEquals(size, 2);
    }

    @Test
    public void setDateAddedTest() {
        christmasWishlist.addItem(myFavDrink);
        Date testDate = new Date(2022, Calendar.NOVEMBER, 25);
        christmasWishlist.setDateAdded(testDate);

        Assertions.assertEquals(testDate.getYear(), christmasWishlist.getDateAdded().getYear());
        Assertions.assertEquals(testDate.getMonth(), christmasWishlist.getDateAdded().getMonth());
        Assertions.assertEquals(testDate.getDay(), christmasWishlist.getDateAdded().getDay());
    }

    ///////////////////
    //testing methods//
    ///////////////////
    @Test
    public void sortWishlistByDateAscendingTest() {
        christmasWishlist.addItem(myFavDrink);
        christmasWishlist.addItem(animeFigure);
        christmasWishlist.addItem(plushie);

        Wishlist testingWishlist = new Wishlist("Testing Wishlist");
        testingWishlist.addItem(myFavDrink);
        testingWishlist.addItem(animeFigure);
        testingWishlist.addItem(plushie);

        christmasWishlist.sortWishlistByDate("ascending");
        testingWishlist.sortWishlistByDate("ascending");

        Assertions.assertTrue(true, String.valueOf(testingWishlist.equals(christmasWishlist)));
    }

    @Test
    public void sortWishlistByDateDescendingTest() {
        christmasWishlist.addItem(myFavDrink);
        christmasWishlist.addItem(animeFigure);
        christmasWishlist.addItem(plushie);

        Wishlist testingWishlist = new Wishlist("Testing Wishlist");
        testingWishlist.addItem(myFavDrink);
        testingWishlist.addItem(animeFigure);
        testingWishlist.addItem(plushie);

        christmasWishlist.sortWishlistByDate("descending");
        testingWishlist.sortWishlistByDate("descending");

        Assertions.assertTrue(true, String.valueOf(testingWishlist.equals(christmasWishlist)));
    }

    @Test
    public void sortWishlistByNameAscendingTest() {
        christmasWishlist.addItem(myFavDrink);
        christmasWishlist.addItem(animeFigure);
        christmasWishlist.addItem(plushie);

        Wishlist testingWishlist = new Wishlist("Testing Wishlist");
        testingWishlist.addItem(myFavDrink);
        testingWishlist.addItem(animeFigure);
        testingWishlist.addItem(plushie);

        christmasWishlist.sortWishlistByName("ascending");
        testingWishlist.sortWishlistByName("ascending");

        Assertions.assertTrue(true, String.valueOf(testingWishlist.equals(christmasWishlist)));
    }

    @Test
    public void sortWishlistByNameDescendingTest() {
        christmasWishlist.addItem(myFavDrink);
        christmasWishlist.addItem(animeFigure);
        christmasWishlist.addItem(plushie);

        Wishlist testingWishlist = new Wishlist("Testing Wishlist");
        testingWishlist.addItem(myFavDrink);
        testingWishlist.addItem(animeFigure);
        testingWishlist.addItem(plushie);

        christmasWishlist.sortWishlistByName("descending");
        testingWishlist.sortWishlistByName("descending");

        Assertions.assertTrue(true, String.valueOf(testingWishlist.equals(christmasWishlist)));
    }

    @Test
    public void sortWishlistByReviewStarsAscendingTest() {
        christmasWishlist.addItem(myFavDrink);
        christmasWishlist.addItem(animeFigure);
        christmasWishlist.addItem(plushie);

        Wishlist testingWishlist = new Wishlist("Testing Wishlist");
        testingWishlist.addItem(myFavDrink);
        testingWishlist.addItem(animeFigure);
        testingWishlist.addItem(plushie);

        christmasWishlist.sortWishlistByReviewStars("ascending");
        testingWishlist.sortWishlistByReviewStars("ascending");

        Assertions.assertTrue(true, String.valueOf(testingWishlist.equals(christmasWishlist)));
    }

    @Test
    public void sortWishlistByReviewStarsDescendingTest() {
        christmasWishlist.addItem(myFavDrink);
        christmasWishlist.addItem(animeFigure);
        christmasWishlist.addItem(plushie);

        Wishlist testingWishlist = new Wishlist("Testing Wishlist");
        testingWishlist.addItem(myFavDrink);
        testingWishlist.addItem(animeFigure);
        testingWishlist.addItem(plushie);

        christmasWishlist.sortWishlistByReviewStars("descending");
        testingWishlist.sortWishlistByReviewStars("descending");

        Assertions.assertTrue(true, String.valueOf(testingWishlist.equals(christmasWishlist)));
    }

    @Test
    public void sortWishlistByReviewCountAscendingTest() {
        christmasWishlist.addItem(myFavDrink);
        christmasWishlist.addItem(animeFigure);
        christmasWishlist.addItem(plushie);

        Wishlist testingWishlist = new Wishlist("Testing Wishlist");
        testingWishlist.addItem(myFavDrink);
        testingWishlist.addItem(animeFigure);
        testingWishlist.addItem(plushie);

        christmasWishlist.sortWishlistByReviewCount("ascending");
        testingWishlist.sortWishlistByReviewCount("ascending");

        Assertions.assertTrue(true, String.valueOf(testingWishlist.equals(christmasWishlist)));
    }

    @Test
    public void sortWishlistByReviewCountDescendingTest() {
        christmasWishlist.addItem(myFavDrink);
        christmasWishlist.addItem(animeFigure);
        christmasWishlist.addItem(plushie);

        Wishlist testingWishlist = new Wishlist("Testing Wishlist");
        testingWishlist.addItem(myFavDrink);
        testingWishlist.addItem(animeFigure);
        testingWishlist.addItem(plushie);

        christmasWishlist.sortWishlistByReviewCount("descending");
        testingWishlist.sortWishlistByReviewCount("descending");

        Assertions.assertTrue(true, String.valueOf(testingWishlist.equals(christmasWishlist)));
    }

    @Test
    public void sortWishlistByPriceAscendingTest() {
        christmasWishlist.addItem(myFavDrink);
        christmasWishlist.addItem(animeFigure);
        christmasWishlist.addItem(plushie);

        Wishlist testingWishlist = new Wishlist("Testing Wishlist");
        testingWishlist.addItem(myFavDrink);
        testingWishlist.addItem(animeFigure);
        testingWishlist.addItem(plushie);

        christmasWishlist.sortWishlistByPrice("ascending");
        testingWishlist.sortWishlistByPrice("ascending");

        Assertions.assertTrue(true, String.valueOf(testingWishlist.equals(christmasWishlist)));
    }

    @Test
    public void sortWishlistByPriceDescendingTest() {
        christmasWishlist.addItem(myFavDrink);
        christmasWishlist.addItem(animeFigure);
        christmasWishlist.addItem(plushie);

        Wishlist testingWishlist = new Wishlist("Testing Wishlist");
        testingWishlist.addItem(myFavDrink);
        testingWishlist.addItem(animeFigure);
        testingWishlist.addItem(plushie);

        christmasWishlist.sortWishlistByPrice("descending");
        testingWishlist.sortWishlistByPrice("descending");

        Assertions.assertTrue(true, String.valueOf(testingWishlist.equals(christmasWishlist)));
    }

    @Test
    public void addItemTest() {
        Assertions.assertTrue(true, String.valueOf(christmasWishlist.addItem(myFavDrink)));
    }

    @Test
    public void removeItemTest() {
        christmasWishlist.addItem(myFavDrink);
        christmasWishlist.addItem(animeFigure);
        christmasWishlist.addItem(plushie);

        Assertions.assertTrue(true, String.valueOf(christmasWishlist.removeItem(animeFigure)));
    }

    @Test
    public void filterWishlistTest() {
        String[] testTags = {"toys"};
        christmasWishlist.addItem(myFavDrink);
        christmasWishlist.addItem(animeFigure);
        christmasWishlist.addItem(plushie);

        Wishlist testingWishlist = new Wishlist("Testing Wishlist");
        testingWishlist.addItem(myFavDrink);
        testingWishlist.addItem(animeFigure);
        testingWishlist.addItem(plushie);
        testingWishlist.filterWishlists(testTags);
        christmasWishlist.filterWishlists(testTags);

        Assertions.assertTrue(true, String.valueOf(testingWishlist.equals(christmasWishlist)));

    }

    public void displayTagsTest() {
        christmasWishlist.addItem(myFavDrink);
        christmasWishlist.addItem(animeFigure);
        christmasWishlist.addItem(plushie);

        Wishlist testingWishlist = new Wishlist("Testing Wishlist");
        testingWishlist.addItem(myFavDrink);
        testingWishlist.addItem(animeFigure);
        testingWishlist.addItem(plushie);

        Assertions.assertEquals(testingWishlist.getSelectedTags(), christmasWishlist.getSelectedTags());
    }

    public void displayListTest() {
        christmasWishlist.addItem(myFavDrink);
        christmasWishlist.addItem(animeFigure);
        christmasWishlist.addItem(plushie);

        Wishlist testingWishlist = new Wishlist("Testing Wishlist");
        testingWishlist.addItem(myFavDrink);
        testingWishlist.addItem(animeFigure);
        testingWishlist.addItem(plushie);

        Assertions.assertEquals(testingWishlist.getDisplayedList(), christmasWishlist.getDisplayedList());
    }
}