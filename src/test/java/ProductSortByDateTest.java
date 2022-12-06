import Controller.ProductComparatorController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Entities.*;

import java.util.Calendar;
import java.util.Date;

public class ProductSortByDateTest {
    Item myFavDrink = new Item("Lime Bubbly", 5.47, 5.00, "www.shoppers.com/bubbly",
            "my favorite drink, bubbly", 69, 4.19,"www.shoppersimage.com/bubbly", null, new String[]{"drink"});
    Item animeFigure = new Item("Starlight Anya Forger", 100, 85.00, "www.amazon.com/AnyaPeanuts",
            "new Anya figure", 150, 4.8,"www.amazonimage.com/AnyaPeanuts", null, new String[]{"figure"});
    Item plushie = new Item("Whale Plushie", 40.99, 30.00, "www.amazon.com/WhalePlushie",
            "Giant Whale Plushie", 1050, 4.3, "www.amazonimage.com/OhWhale", null, new String[]{"toys"});

    ProductComparatorController christmasWishlist = new ProductComparatorController("Christmas Wishlist");
    Calendar dateInstance = Calendar.getInstance();

    @Test
    public void ProductSortByDateTestAscending() {
        christmasWishlist.addProduct(myFavDrink);
        christmasWishlist.addProduct(animeFigure);
        christmasWishlist.addProduct(plushie);

        dateInstance.set(2022, Calendar.SEPTEMBER, 15);
        Date date1 = dateInstance.getTime();

        dateInstance.set(2022, Calendar.NOVEMBER, 15);
        Date date2 = dateInstance.getTime();

        dateInstance.set(2022, Calendar.DECEMBER, 15);
        Date date3 = dateInstance.getTime();

        myFavDrink.setDateAdded(date3);
        animeFigure.setDateAdded(date2);
        plushie.setDateAdded(date1);

        christmasWishlist.sortList("ascending", "date");

        Assertions.assertEquals(date1, (christmasWishlist.getProductList().get(0).getProductDateAdded()));
        Assertions.assertEquals(date2, (christmasWishlist.getProductList().get(1).getProductDateAdded()));
        Assertions.assertEquals(date3, (christmasWishlist.getProductList().get(2).getProductDateAdded()));
    }

    @Test
    public void SortListByDateTestDescending() {
        christmasWishlist.addProduct(myFavDrink);
        christmasWishlist.addProduct(animeFigure);
        christmasWishlist.addProduct(plushie);

        Calendar testDate = Calendar.getInstance();
        testDate.set(2022, Calendar.SEPTEMBER, 15);
        Date date1 = testDate.getTime();

        testDate.set(2022, Calendar.NOVEMBER, 15);
        Date date2 = testDate.getTime();

        testDate.set(2022, Calendar.DECEMBER, 15);
        Date date3 = testDate.getTime();

        myFavDrink.setDateAdded(date3);
        animeFigure.setDateAdded(date2);
        plushie.setDateAdded(date1);

        christmasWishlist.sortList("descending", "date");

        Assertions.assertEquals(date1, (christmasWishlist.getProductList().get(2).getProductDateAdded()));
        Assertions.assertEquals(date2, (christmasWishlist.getProductList().get(1).getProductDateAdded()));
        Assertions.assertEquals(date3, (christmasWishlist.getProductList().get(0).getProductDateAdded()));
    }
}
