import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Entities.*;

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

    }

    @Test
    public void getItemListTest() {

    }

    @Test
    public void getDisplayedListTest() {

    }

    @Test
    public void getDateAddedTest() {

    }

    @Test
    public void getSelectedTagsTest() {

    }

    @Test
    public void setDateAddedTest() {

    }
    ///////////////////
    //testing methods//
    ///////////////////
    @Test
    public void sortWishlistByDateTest() {

    }

    @Test
    public void sortWishlistByNameTest() {

    }

    @Test
    public void sortWishlistByReviewStars() {

    }

    @Test
    public void sortWishlistByReviewCount() {

    }

    @Test
    public void sortWishlistByPrice() {

    }

    @Test
    public void addItemTest() {

    }

    @Test
    public void removeItemTest() {

    }

    @Test
    public void filterWishlistTest() {

    }

    public void displayTagsTest() {

    }

    public void displayListTest() {

    }
}
