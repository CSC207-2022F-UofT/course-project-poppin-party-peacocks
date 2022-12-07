import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Entities.*;

import java.util.Calendar;
import java.util.Date;

public class WishlistTest {
    Item myFavDrink = new Item("Lime Bubbly", 5.47, 5.00, "www.shoppers.com/bubbly",
            "my favorite drink, bubbly", 69, 4.19,"www.shoppersimage.com/bubbly", null, new String[]{"drink"});
    Item animeFigure = new Item("Starlight Anya Forger", 100, 85.00, "www.amazon.com/AnyaPeanuts",
            "new Anya figure", 150, 4.8,"www.amazonimage.com/AnyaPeanuts", null, new String[]{"figure"});
    Item plushie = new Item("Whale Plushie", 40.99, 30.00, "www.amazon.com/WhalePlushie",
            "Giant Whale Plushie", 1050, 4.3, "www.amazonimage.com/OhWhale", null, new String[]{"toys"});

    Wishlist christmasWishlist = new Wishlist("Christmas Wishlist");
    Calendar dateInstance = Calendar.getInstance();

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

        dateInstance.set(2022, Calendar.SEPTEMBER, 15);
        Date date1 = dateInstance.getTime();
        dateInstance.set(2022, Calendar.NOVEMBER, 15);
        Date date2 = dateInstance.getTime();
        dateInstance.set(2022, Calendar.DECEMBER, 15);
        Date date3 = dateInstance.getTime();

        myFavDrink.setDateAdded(date3);
        animeFigure.setDateAdded(date2);
        plushie.setDateAdded(date1);

        //myFavDrink testing
        Assertions.assertEquals(christmasWishlist.getProductList().get(0).getProductDateAdded(), date3);

        //animeFigure testing
        Assertions.assertEquals(christmasWishlist.getProductList().get(1).getProductDateAdded(), date2);

        //plushie testing
        Assertions.assertEquals(christmasWishlist.getProductList().get(2).getProductDateAdded(), date1);
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

        dateInstance.set(2022, Calendar.SEPTEMBER, 15);
        Date date1 = dateInstance.getTime();
        dateInstance.set(2022, Calendar.NOVEMBER, 15);
        Date date2 = dateInstance.getTime();
        dateInstance.set(2022, Calendar.DECEMBER, 15);
        Date date3 = dateInstance.getTime();

        myFavDrink.setDateAdded(date3);
        animeFigure.setDateAdded(date2);
        plushie.setDateAdded(date1);

        //myFavDrink testing
        Assertions.assertEquals(christmasWishlist.getProductList().get(0).getProductDateAdded(), date3);

        //animeFigure testing
        Assertions.assertEquals(christmasWishlist.getProductList().get(1).getProductDateAdded(), date2);

        //plushie testing
        Assertions.assertEquals(christmasWishlist.getProductList().get(2).getProductDateAdded(), date1);
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