import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Entities.*;

public class ItemPriceComparatorTest {
    Item myFavDrink = new Item("Lime Bubbly", 5.47, 5.00, "www.shoppers.com/bubbly",
            "my favorite drink, bubbly", new String[]{"Drink"}, 69, 4.19,"www.shoppersimage.com/bubbly");
    Item animeFigure = new Item("Starlight Anya Forger", 100, 85.00, "www.amazon.com/AnyaPeanuts", "new Anya figure", new String[]{"Figure"}, 150, 4.8,"www.amazonimage.com/AnyaPeanuts" );
    Item plushie = new Item("Whale Plushie", 40.99, 30.00, "www.amazon.com/WhalePlushie",
            "Giant Whale Plushie", new String[]{"toys"}, 1050, 4.3, "www.amazonimage.com/OhWhale");

    Wishlist christmasWishlist = new Wishlist("Christmas Wishlist");

//    @Test
//    public void ItemPriceComparatorTestAscending() {
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
//    public void ItemPriceComparatorTestDescending() {
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
}
