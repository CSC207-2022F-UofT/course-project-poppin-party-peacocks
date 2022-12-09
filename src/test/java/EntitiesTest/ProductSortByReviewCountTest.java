package EntitiesTest;

import Controller.ProductComparatorController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Entities.*;

public class ProductSortByReviewCountTest {
    Item myFavDrink = new Item("Lime Bubbly", 5.47, 5.00, "www.shoppers.com/bubbly",
            "my favorite drink, bubbly",69, 4.19,"www.shoppersimage.com/bubbly");
    Item animeFigure = new Item("Starlight Anya Forger", 100, 85.00, "www.amazon.com/AnyaPeanuts",
            "new Anya figure", 150, 4.8,"www.amazonimage.com/AnyaPeanuts" );
    Item plushie = new Item("Whale Plushie", 40.99, 30.00, "www.amazon.com/WhalePlushie",
            "Giant Whale Plushie",1050, 4.3, "www.amazonimage.com/OhWhale");

    @Test
    public void ProductSortByReviewCountTestAscending() {
        Wishlist list1 = new Wishlist("wishlist 1");
        Wishlist list2 = new Wishlist("wishlist 2");

        ProductComparatorController controller1 = new ProductComparatorController(list1);
        ProductComparatorController controller2 = new ProductComparatorController(list2);

        list1.addProduct(myFavDrink);
        list1.addProduct(animeFigure);
        list1.addProduct(plushie);
        list2.addProduct(myFavDrink);
        list2.addProduct(animeFigure);
        list2.addProduct(plushie);

        controller1.sortList("ascending", "review count");
        controller2.sortList("ascending", "review count");

        Assertions.assertEquals(69, list1.getDisplayedList().get(0).getReviewCount());
        Assertions.assertEquals(150,list1.getDisplayedList().get(1).getReviewCount());
        Assertions.assertEquals(1050, list1.getDisplayedList().get(2).getReviewCount());

        Assertions.assertEquals(69, list2.getDisplayedList().get(0).getReviewCount());
        Assertions.assertEquals(150, list2.getDisplayedList().get(1).getReviewCount());
        Assertions.assertEquals(1050,list2.getDisplayedList().get(2).getReviewCount());
    }

    @Test
    public void ProductSortByReviewCountTestDescending() {
        Wishlist list1 = new Wishlist("wishlist 1");
        Wishlist list2 = new Wishlist("wishlist 2");

        ProductComparatorController controller1 = new ProductComparatorController(list1);
        ProductComparatorController controller2 = new ProductComparatorController(list2);

        list1.addProduct(myFavDrink);
        list1.addProduct(animeFigure);
        list1.addProduct(plushie);
        list2.addProduct(myFavDrink);
        list2.addProduct(animeFigure);
        list2.addProduct(plushie);

        controller1.sortList("descending", "review count");
        controller2.sortList("descending", "review count");

        Assertions.assertEquals(69, list1.getDisplayedList().get(2).getReviewCount());
        Assertions.assertEquals(150,list1.getDisplayedList().get(1).getReviewCount());
        Assertions.assertEquals(1050, list1.getDisplayedList().get(0).getReviewCount());

        Assertions.assertEquals(69, list2.getDisplayedList().get(2).getReviewCount());
        Assertions.assertEquals(150, list2.getDisplayedList().get(1).getReviewCount());
        Assertions.assertEquals(1050,list2.getDisplayedList().get(0).getReviewCount());
    }
}
