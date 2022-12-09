package EntitiesTest;

import Controller.ProductComparatorController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Entities.*;

import java.util.Calendar;
import java.util.Date;

public class ProductSortByDateTest {
    Date nullDate = new Date();
    Item myFavDrink = new Item("Lime Bubbly", 5.47, 5.00, "www.shoppers.com/bubbly",
            "my favorite drink, bubbly", 69, 4.19,"www.shoppersimage.com/bubbly", nullDate);
    Item animeFigure = new Item("Starlight Anya Forger", 100, 85.00, "www.amazon.com/AnyaPeanuts",
            "new Anya figure", 150, 4.8,"www.amazonimage.com/AnyaPeanuts", nullDate);
    Item plushie = new Item("Whale Plushie", 40.99, 30.00, "www.amazon.com/WhalePlushie",
            "Giant Whale Plushie", 1050, 4.3, "www.amazonimage.com/OhWhale", nullDate);

    Calendar dateInstance = Calendar.getInstance();

    @Test
    public void ProductSortByDateTestAscending() {
        dateInstance.set(2022, Calendar.SEPTEMBER, 15);
        Date date1 = dateInstance.getTime();

        dateInstance.set(2022, Calendar.NOVEMBER, 15);
        Date date2 = dateInstance.getTime();

        dateInstance.set(2022, Calendar.DECEMBER, 15);
        Date date3 = dateInstance.getTime();

        myFavDrink.setDateAdded(date3);
        animeFigure.setDateAdded(date2);
        plushie.setDateAdded(date1);

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

        Assertions.assertEquals(date3, list1.getDisplayedList().get(0).getProductDateAdded());
        Assertions.assertEquals(date2,list1.getDisplayedList().get(1).getProductDateAdded());
        Assertions.assertEquals(date1, list1.getDisplayedList().get(2).getProductDateAdded());

        Assertions.assertEquals(date3, list2.getDisplayedList().get(0).getProductDateAdded());
        Assertions.assertEquals(date2, list2.getDisplayedList().get(1).getProductDateAdded());
        Assertions.assertEquals(date1,list2.getDisplayedList().get(2).getProductDateAdded());
    }

    @Test
    public void SortListByDateTestDescending() {
        dateInstance.set(2022, Calendar.SEPTEMBER, 15);
        Date date1 = dateInstance.getTime();

        dateInstance.set(2022, Calendar.NOVEMBER, 15);
        Date date2 = dateInstance.getTime();

        dateInstance.set(2022, Calendar.DECEMBER, 15);
        Date date3 = dateInstance.getTime();

        myFavDrink.setDateAdded(date3);
        animeFigure.setDateAdded(date2);
        plushie.setDateAdded(date1);

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

        Assertions.assertEquals(date3, list1.getDisplayedList().get(2).getProductDateAdded());
        Assertions.assertEquals(date2,list1.getDisplayedList().get(1).getProductDateAdded());
        Assertions.assertEquals(date1, list1.getDisplayedList().get(0).getProductDateAdded());

        Assertions.assertEquals(date3, list2.getDisplayedList().get(2).getProductDateAdded());
        Assertions.assertEquals(date2, list2.getDisplayedList().get(1).getProductDateAdded());
        Assertions.assertEquals(date1,list2.getDisplayedList().get(0).getProductDateAdded());
    }
}
