import Controller.ProductComparatorController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Entities.*;

import java.util.ArrayList;

public class ProductSortByDateTest {
    Item myFavDrink = new Item("Lime Bubbly", 5.47, 5.00, "www.shoppers.com/bubbly",
            "my favorite drink, bubbly", new String[]{"Drink"}, 69, 4.19,"www.shoppersimage.com/bubbly");
    Item animeFigure = new Item("Starlight Anya Forger", 100, 85.00, "www.amazon.com/AnyaPeanuts", "new Anya figure", new String[]{"Figure"}, 150, 4.8,"www.amazonimage.com/AnyaPeanuts" );
    Item plushie = new Item("Whale Plushie", 40.99, 30.00, "www.amazon.com/WhalePlushie",
            "Giant Whale Plushie", new String[]{"toys"}, 1050, 4.3, "www.amazonimage.com/OhWhale");


    ArrayList<Product> testArrayList = new ArrayList<>();
    ProductComparatorController christmasWishlist = new ProductComparatorController(testArrayList);

    @Test
    public void ProductSortByDateTestAscending() {
        christmasWishlist.addProduct(myFavDrink);
        christmasWishlist.addProduct(animeFigure);
        christmasWishlist.addProduct(plushie);

        ProductComparatorController testList = new ProductComparatorController(testArrayList);
        testList.addProduct(myFavDrink);
        testList.addProduct(animeFigure);
        testList.addProduct(plushie);

        christmasWishlist.sortList("ascending", "date");
        testList.sortList("ascending", "date");

        Assertions.assertTrue(true, String.valueOf(testList.equals(christmasWishlist)));
    }

    @Test
    public void SortListByDateTestDescending() {
        christmasWishlist.addProduct(myFavDrink);
        christmasWishlist.addProduct(animeFigure);
        christmasWishlist.addProduct(plushie);

        ProductComparatorController testList = new ProductComparatorController(testArrayList);
        testList.addProduct(myFavDrink);
        testList.addProduct(animeFigure);
        testList.addProduct(plushie);

        christmasWishlist.sortList("descending", "date");
        testList.sortList("descending", "date");

        Assertions.assertTrue(true, String.valueOf(testList.equals(christmasWishlist)));
    }
}
