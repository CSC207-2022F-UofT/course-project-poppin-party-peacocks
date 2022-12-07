package EntitiesTest;

import Controller.ProductComparatorController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Entities.*;

public class ProductSortByReviewStarTest {
    Item myFavDrink = new Item("Lime Bubbly", 5.47, 5.00, "www.shoppers.com/bubbly",
            "my favorite drink, bubbly", new String[]{"Drink"}, 69, 4.19,"www.shoppersimage.com/bubbly");
    Item animeFigure = new Item("Starlight Anya Forger", 100, 85.00, "www.amazon.com/AnyaPeanuts",
            "new Anya figure", new String[]{"Figure"}, 150, 4.8,"www.amazonimage.com/AnyaPeanuts" );
    Item plushie = new Item("Whale Plushie", 40.99, 30.00, "www.amazon.com/WhalePlushie",
            "Giant Whale Plushie", new String[]{"toys"}, 1050, 4.3, "www.amazonimage.com/OhWhale");

    @Test
    public void ItemReviewStarComparatorTestAscending() {
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

        controller1.sortList("ascending", "review star");
        controller2.sortList("ascending", "review star");

        Assertions.assertEquals(4.19, list1.getProductList().get(0).getReviewStars());
        Assertions.assertEquals(4.3,list1.getProductList().get(1).getReviewStars());
        Assertions.assertEquals(4.8, list1.getProductList().get(2).getReviewStars());

        Assertions.assertEquals(4.19, list2.getProductList().get(0).getReviewStars());
        Assertions.assertEquals(4.3, list2.getProductList().get(1).getReviewStars());
        Assertions.assertEquals(4.8,list2.getProductList().get(2).getReviewStars());
    }

    @Test
    public void ItemReviewStarComparatorTestDescending() {
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

        controller1.sortList("descending", "review star");
        controller2.sortList("descending", "review star");

        Assertions.assertEquals(4.19, list1.getProductList().get(2).getReviewStars());
        Assertions.assertEquals(4.3,list1.getProductList().get(1).getReviewStars());
        Assertions.assertEquals(4.8, list1.getProductList().get(0).getReviewStars());

        Assertions.assertEquals(4.19, list2.getProductList().get(2).getReviewStars());
        Assertions.assertEquals(4.3, list2.getProductList().get(1).getReviewStars());
        Assertions.assertEquals(4.8,list2.getProductList().get(0).getReviewStars());
    }
}
