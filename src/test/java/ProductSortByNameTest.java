import Controller.ProductComparatorController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Entities.*;

public class ProductSortByNameTest {
    Item myFavDrink = new Item("Lime Bubbly", 5.47, 5.00, "www.shoppers.com/bubbly",
            "my favorite drink, bubbly", new String[]{"Drink"}, 69, 4.19,"www.shoppersimage.com/bubbly");
    Item animeFigure = new Item("Starlight Anya Forger", 100, 85.00, "www.amazon.com/AnyaPeanuts", "new Anya figure", new String[]{"Figure"}, 150, 4.8,"www.amazonimage.com/AnyaPeanuts" );
    Item plushie = new Item("Whale Plushie", 40.99, 30.00, "www.amazon.com/WhalePlushie",
            "Giant Whale Plushie", new String[]{"toys"}, 1050, 4.3, "www.amazonimage.com/OhWhale");

    @Test
    public void ProductSortByNameTestAscending() {
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

        controller1.sortList("ascending", "name");
        controller2.sortList("ascending", "name");

        Assertions.assertEquals("Lime Bubbly", list1.getProductList().get(0).getProductName());
        Assertions.assertEquals("Starlight Anya Forger",list1.getProductList().get(1).getProductName());
        Assertions.assertEquals("Whale Plushie", list1.getProductList().get(2).getProductName());

        Assertions.assertEquals("Lime Bubbly", list2.getProductList().get(0).getProductName());
        Assertions.assertEquals("Starlight Anya Forger", list2.getProductList().get(1).getProductName());
        Assertions.assertEquals("Whale Plushie",list2.getProductList().get(2).getProductName());
    }

    @Test
    public void ProductSortByNameTestDescending() {
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

        controller1.sortList("descending", "name");
        controller2.sortList("descending", "name");

        Assertions.assertEquals("Lime Bubbly", list1.getProductList().get(2).getProductName());
        Assertions.assertEquals("Starlight Anya Forger",list1.getProductList().get(1).getProductName());
        Assertions.assertEquals("Whale Plushie", list1.getProductList().get(0).getProductName());

        Assertions.assertEquals("Lime Bubbly", list2.getProductList().get(2).getProductName());
        Assertions.assertEquals("Starlight Anya Forger", list2.getProductList().get(1).getProductName());
        Assertions.assertEquals("Whale Plushie",list2.getProductList().get(0).getProductName());
    }
}
