import Controller.ProductComparatorController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Entities.*;

public class ProductSortByPriceTest {
    Item myFavDrink = new Item("Lime Bubbly", 5.47, 5.00, "www.shoppers.com/bubbly",
            "my favorite drink, bubbly", new String[]{"Drink"}, 69, 4.19,"www.shoppersimage.com/bubbly");
    Item animeFigure = new Item("Starlight Anya Forger", 100, 85.00, "www.amazon.com/AnyaPeanuts", "new Anya figure", new String[]{"Figure"}, 150, 4.8,"www.amazonimage.com/AnyaPeanuts" );
    Item plushie = new Item("Whale Plushie", 40.99, 30.00, "www.amazon.com/WhalePlushie",
            "Giant Whale Plushie", new String[]{"toys"}, 1050, 4.3, "www.amazonimage.com/OhWhale");

    ProductComparatorController christmasWishlist = new ProductComparatorController("Christmas Wishlist");

    @Test
    public void ProductSortByPriceTestAscending() {
        christmasWishlist.addProduct(myFavDrink);
        christmasWishlist.addProduct(animeFigure);
        christmasWishlist.addProduct(plushie);

        christmasWishlist.sortList("ascending", "price");

        Assertions.assertEquals(5.47, christmasWishlist.getProductList().get(0).getProductPrice());
        Assertions.assertEquals(40.99, christmasWishlist.getProductList().get(1).getProductPrice());
        Assertions.assertEquals(100, christmasWishlist.getProductList().get(2).getProductPrice());
    }

    @Test
    public void ProductSortByPriceTestTestDescending() {
        christmasWishlist.addProduct(myFavDrink);
        christmasWishlist.addProduct(animeFigure);
        christmasWishlist.addProduct(plushie);

        christmasWishlist.sortList("descending", "price");

        Assertions.assertEquals(5.47, christmasWishlist.getProductList().get(2).getProductPrice());
        Assertions.assertEquals(40.99, christmasWishlist.getProductList().get(1).getProductPrice());
        Assertions.assertEquals(100, christmasWishlist.getProductList().get(0).getProductPrice());
    }
}
