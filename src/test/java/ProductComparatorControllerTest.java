import Controller.ProductComparatorController;
import Entities.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

public class ProductComparatorControllerTest {
    Date date1 = new Date(2022, Calendar.DECEMBER, 15);
    Date date2 = new Date(2022, Calendar.NOVEMBER, 15);
    Date date3 = new Date(2022, Calendar.SEPTEMBER, 15);
    Item myFavDrink = new Item("Lime Bubbly", 5.47, 5.00, "www.shoppers.com/bubbly",
            "my favorite drink, bubbly", 69, 4.19,"www.shoppersimage.com/bubbly", date3, new String[]{"drink"});
    Item animeFigure = new Item("Starlight Anya Forger", 100, 85.00, "www.amazon.com/AnyaPeanuts",
            "new Anya figure", 150, 4.8,"www.amazonimage.com/AnyaPeanuts", date2, new String[]{"figure"});
    Item plushie = new Item("Whale Plushie", 40.99, 30.00, "www.amazon.com/WhalePlushie",
            "Giant Whale Plushie", 1050, 4.3, "www.amazonimage.com/OhWhale", date1, new String[]{"toys"});

    ProductComparatorController christmasWishlist = new ProductComparatorController("Christmas Wishlist");

    @Test
    public void getNameTest() {
        Assertions.assertEquals("Christmas Wishlist", christmasWishlist.getName());
    }

    @Test
    public void getProductListTest() {
        christmasWishlist.addProduct(myFavDrink);
        christmasWishlist.addProduct(animeFigure);
        christmasWishlist.addProduct(plushie);

        Assertions.assertEquals(christmasWishlist.getProductList().get(0), myFavDrink);
        Assertions.assertEquals(christmasWishlist.getProductList().get(1), animeFigure);
        Assertions.assertEquals(christmasWishlist.getProductList().get(2), plushie);
    }

    @Test
    public void getDisplayedListTest() {
        christmasWishlist.addProduct(myFavDrink);
        christmasWishlist.addProduct(animeFigure);
        christmasWishlist.addProduct(plushie);

        Assertions.assertEquals(christmasWishlist.getDisplayedList().get(0), myFavDrink);
        Assertions.assertEquals(christmasWishlist.getDisplayedList().get(1), animeFigure);
        Assertions.assertEquals(christmasWishlist.getDisplayedList().get(2), plushie);
    }

    @Test
    public void getDateAddedTest() {
        christmasWishlist.addProduct(myFavDrink);
        christmasWishlist.addProduct(animeFigure);
        christmasWishlist.addProduct(plushie);
        Date testDate1 = new Date(2022, Calendar.DECEMBER, 15);
        Date testDate2 = new Date(2022, Calendar.NOVEMBER, 15);
        Date testDate3 = new Date(2022, Calendar.SEPTEMBER, 15);

        //myFavDrink testing
        Assertions.assertEquals(christmasWishlist.getProductList().get(0).getProductDateAdded().getDate(), testDate3.getDate());

        //animeFigure testing
        Assertions.assertEquals(christmasWishlist.getProductList().get(1).getProductDateAdded().getDate(), testDate2.getDate());

        //plushie testing
        Assertions.assertEquals(christmasWishlist.getProductList().get(2).getProductDateAdded().getDate(), testDate1.getDate());
    }

    @Test
    public void getSelectedTagsTest() {
        //no implementation needed, tag related things will be deleted project wide
    }

    @Test
    public void getListSizeTest(){
        christmasWishlist.addProduct(myFavDrink);
        christmasWishlist.addProduct(animeFigure);
        christmasWishlist.addProduct(plushie);
        Assertions.assertEquals(christmasWishlist.getListSize(), 3);
    }

    @Test
    public void setDateAddedTest() {
        christmasWishlist.addProduct(myFavDrink);
        christmasWishlist.addProduct(animeFigure);
        christmasWishlist.addProduct(plushie);
        Date testDate1 = new Date(2022, Calendar.DECEMBER, 15);
        Date testDate2 = new Date(2022, Calendar.NOVEMBER, 15);
        Date testDate3 = new Date(2022, Calendar.SEPTEMBER, 15);

        //myFavDrink testing
        Assertions.assertEquals(testDate3.getDate(), christmasWishlist.getProductList().get(0).getProductDateAdded().getDate());

        //animeFigure testing
        Assertions.assertEquals(testDate2.getDate(), christmasWishlist.getProductList().get(1).getProductDateAdded().getDate());

        //plushie testing
        Assertions.assertEquals(testDate1.getDate(), christmasWishlist.getProductList().get(2).getProductDateAdded().getDate());
    }

    @Test void setNameTest(){
        christmasWishlist.setName("new christmas wishlist");
        Assertions.assertEquals(christmasWishlist.getName(), "new christmas wishlist");
    }

    @Test
    public void addItemTest() {
        Assertions.assertTrue(true, String.valueOf(christmasWishlist.addProduct(myFavDrink)));
    }

    @Test
    public void removeItemTest() {
        christmasWishlist.addProduct(myFavDrink);
        christmasWishlist.addProduct(animeFigure);
        christmasWishlist.addProduct(plushie);

        Assertions.assertTrue(true, String.valueOf(christmasWishlist.removeProduct(animeFigure)));
    }
}
