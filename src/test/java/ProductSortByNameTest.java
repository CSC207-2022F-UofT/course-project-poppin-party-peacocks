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

    ProductComparatorController christmasWishlist = new ProductComparatorController("Christmas Wishlist");

    @Test
    public void ProductSortByNameTestAscending() {
        christmasWishlist.addProduct(myFavDrink);
        christmasWishlist.addProduct(animeFigure);
        christmasWishlist.addProduct(plushie);

        christmasWishlist.sortList("ascending", "name");

        Assertions.assertEquals("Lime Bubbly", christmasWishlist.getProductList().get(0).getProductName());
        Assertions.assertEquals("Starlight Anya Forger", christmasWishlist.getProductList().get(1).getProductName());
        Assertions.assertEquals("Whale Plushie", christmasWishlist.getProductList().get(2).getProductName());
    }

    @Test
    public void ProductSortByNameTestDescending() {
        christmasWishlist.addProduct(myFavDrink);
        christmasWishlist.addProduct(animeFigure);
        christmasWishlist.addProduct(plushie);

        christmasWishlist.sortList("descending", "name");

        Assertions.assertEquals("Lime Bubbly", christmasWishlist.getProductList().get(2).getProductName());
        Assertions.assertEquals("Starlight Anya Forger", christmasWishlist.getProductList().get(1).getProductName());
        Assertions.assertEquals("Whale Plushie", christmasWishlist.getProductList().get(0).getProductName());
    }
}
