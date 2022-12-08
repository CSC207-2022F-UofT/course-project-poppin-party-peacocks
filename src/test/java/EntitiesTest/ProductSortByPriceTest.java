package EntitiesTest;

import Controller.ProductComparatorController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Entities.*;

public class ProductSortByPriceTest {
    Product myFavDrink = new Item("Lime Bubbly", 5.47, 5.00, "www.shoppers.com/bubbly",
            "my favorite drink, bubbly", 69, 4.19,"www.shoppersimage.com/bubbly");
    Item animeFigure = new Item("Starlight Anya Forger", 100, 85.00, "www.amazon.com/AnyaPeanuts",
            "new Anya figure", 150, 4.8,"www.amazonimage.com/AnyaPeanuts" );
    Item plushie = new Item("Whale Plushie", 40.99, 30.00, "www.amazon.com/WhalePlushie",
            "Giant Whale Plushie", 1050, 4.3, "www.amazonimage.com/OhWhale");


    @Test
    public void ProductSortByPriceTestAscending() {
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

        controller1.sortList("ascending", "price");
        controller2.sortList("ascending", "price");

        Assertions.assertEquals(5.47, list1.getDisplayedList().get(0).getProductPrice());
        Assertions.assertEquals(40.99,list1.getDisplayedList().get(1).getProductPrice());
        Assertions.assertEquals(100, list1.getDisplayedList().get(2).getProductPrice());

        Assertions.assertEquals(5.47, list2.getDisplayedList().get(0).getProductPrice());
        Assertions.assertEquals(40.99, list2.getDisplayedList().get(1).getProductPrice());
        Assertions.assertEquals(100,list2.getDisplayedList().get(2).getProductPrice());
    }

    @Test
    public void ProductSortByPriceTestTestDescending() {
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

        controller1.sortList("descending", "price");
        controller2.sortList("descending", "price");

        Assertions.assertEquals(5.47, list1.getDisplayedList().get(2).getProductPrice());
        Assertions.assertEquals(40.99,list1.getDisplayedList().get(1).getProductPrice());
        Assertions.assertEquals(100, list1.getDisplayedList().get(0).getProductPrice());

        Assertions.assertEquals(5.47, list2.getDisplayedList().get(2).getProductPrice());
        Assertions.assertEquals(40.99, list2.getDisplayedList().get(1).getProductPrice());
        Assertions.assertEquals(100,list2.getDisplayedList().get(0).getProductPrice());
    }
}
