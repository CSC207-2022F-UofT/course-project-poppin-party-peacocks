package ControllerTest;

import Controller.ProductComparatorController;
import Entities.*;
import UseCases.Comparator.ProductComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ProductComparatorControllerTest {
    Item myFavDrink = new Item("Lime Bubbly", 5.47, 5.00, "www.shoppers.com/bubbly",
            "my favorite drink, bubbly", 69, 4.19,"www.shoppersimage.com/bubbly", null, new String[]{"drink"});
    Item animeFigure = new Item("Starlight Anya Forger", 100, 85.00, "www.amazon.com/AnyaPeanuts",
            "new Anya figure", 150, 4.8,"www.amazonimage.com/AnyaPeanuts", null, new String[]{"figure"});
    Item plushie = new Item("Whale Plushie", 40.99, 30.00, "www.amazon.com/WhalePlushie",
            "Giant Whale Plushie", 1050, 4.3, "www.amazonimage.com/OhWhale", null, new String[]{"toys"});

    Calendar dateInstance = Calendar.getInstance();

    //date
    @Test
    public void sortingHelperAndSortListDateAscendingTest() {
        ProductComparator newComparator = new ProductDateComparator();

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

        controller1.sortList("ascending", "date");
        controller2.sortingHelper("ascending", newComparator);

        Assertions.assertEquals(list1.getProductList(), list2.getProductList());
    }

    @Test
    public void sortingHelperAndSortListDateDescendingTest() {
        ProductComparator newComparator = new ProductDateComparator();

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

        controller1.sortList("descending", "date");
        controller2.sortingHelper("descending", newComparator);

        Assertions.assertEquals(list1.getProductList(), list2.getProductList());
    }

    //name
    @Test
    public void sortingHelperAndSortListNameAscendingTest() {
        ProductComparator newComparator = new ProductNameComparator();

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
        controller2.sortingHelper("ascending", newComparator);

        Assertions.assertEquals("Lime Bubbly", list1.getProductList().get(0).getProductName());
        Assertions.assertEquals("Starlight Anya Forger",list1.getProductList().get(1).getProductName());
        Assertions.assertEquals("Whale Plushie", list1.getProductList().get(2).getProductName());

        Assertions.assertEquals("Lime Bubbly", list2.getProductList().get(0).getProductName());
        Assertions.assertEquals("Starlight Anya Forger", list2.getProductList().get(1).getProductName());
        Assertions.assertEquals("Whale Plushie",list2.getProductList().get(2).getProductName());

        Assertions.assertEquals(list1.getProductList().get(0).getProductName(), list2.getProductList().get(0).getProductName());
        Assertions.assertEquals(list1.getProductList().get(1).getProductName(), list2.getProductList().get(1).getProductName());
        Assertions.assertEquals(list1.getProductList().get(2).getProductName(), list2.getProductList().get(2).getProductName());
    }

    @Test
    public void sortingHelperAndSortListNameDescendingTest() {
        ProductComparator newComparator = new ProductNameComparator();

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
        controller2.sortingHelper("descending", newComparator);

        Assertions.assertEquals("Lime Bubbly", list1.getProductList().get(2).getProductName());
        Assertions.assertEquals("Starlight Anya Forger",list1.getProductList().get(1).getProductName());
        Assertions.assertEquals("Whale Plushie", list1.getProductList().get(0).getProductName());

        Assertions.assertEquals("Lime Bubbly", list2.getProductList().get(2).getProductName());
        Assertions.assertEquals("Starlight Anya Forger", list2.getProductList().get(1).getProductName());
        Assertions.assertEquals("Whale Plushie",list2.getProductList().get(0).getProductName());

        Assertions.assertEquals(list1.getProductList().get(0).getProductName(), list2.getProductList().get(0).getProductName());
        Assertions.assertEquals(list1.getProductList().get(1).getProductName(), list2.getProductList().get(1).getProductName());
        Assertions.assertEquals(list1.getProductList().get(2).getProductName(), list2.getProductList().get(2).getProductName());
    }

    //price
    @Test
    public void sortingHelperAndSortListPriceAscendingTest() {
        ProductComparator newComparator = new ProductPriceComparator();

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
        controller2.sortingHelper("ascending", newComparator);

        Assertions.assertEquals(5.47, list1.getProductList().get(0).getProductPrice());
        Assertions.assertEquals(40.99,list1.getProductList().get(1).getProductPrice());
        Assertions.assertEquals(100, list1.getProductList().get(2).getProductPrice());

        Assertions.assertEquals(5.47, list2.getProductList().get(0).getProductPrice());
        Assertions.assertEquals(40.99, list2.getProductList().get(1).getProductPrice());
        Assertions.assertEquals(100,list2.getProductList().get(2).getProductPrice());

        Assertions.assertEquals(list1.getProductList().get(0).getPriceChange(), list2.getProductList().get(0).getPriceChange());
        Assertions.assertEquals(list1.getProductList().get(1).getPriceChange(), list2.getProductList().get(1).getPriceChange());
        Assertions.assertEquals(list1.getProductList().get(2).getPriceChange(), list2.getProductList().get(2).getPriceChange());
    }

    @Test
    public void sortingHelperAndSortListPriceDescendingTest() {
        ProductComparator newComparator = new ProductPriceComparator();

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
        controller2.sortingHelper("descending", newComparator);

        Assertions.assertEquals(5.47, list1.getProductList().get(2).getProductPrice());
        Assertions.assertEquals(40.99,list1.getProductList().get(1).getProductPrice());
        Assertions.assertEquals(100, list1.getProductList().get(0).getProductPrice());

        Assertions.assertEquals(5.47, list2.getProductList().get(2).getProductPrice());
        Assertions.assertEquals(40.99, list2.getProductList().get(1).getProductPrice());
        Assertions.assertEquals(100,list2.getProductList().get(0).getProductPrice());

        Assertions.assertEquals(list1.getProductList().get(0).getPriceChange(), list2.getProductList().get(0).getPriceChange());
        Assertions.assertEquals(list1.getProductList().get(1).getPriceChange(), list2.getProductList().get(1).getPriceChange());
        Assertions.assertEquals(list1.getProductList().get(2).getPriceChange(), list2.getProductList().get(2).getPriceChange());
    }

    //review count
    @Test
    public void sortingHelperAndSortListReviewCountAscendingTest() {
        ProductComparator newComparator = new ProductReviewCountComparator();

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

        controller1.sortList("ascending", "review count");
        controller2.sortingHelper("ascending", newComparator);

        Assertions.assertEquals(69, list1.getProductList().get(0).getReviewCount());
        Assertions.assertEquals(150,list1.getProductList().get(1).getReviewCount());
        Assertions.assertEquals(1050, list1.getProductList().get(2).getReviewCount());

        Assertions.assertEquals(69, list2.getProductList().get(0).getReviewCount());
        Assertions.assertEquals(150, list2.getProductList().get(1).getReviewCount());
        Assertions.assertEquals(1050,list2.getProductList().get(2).getReviewCount());

        Assertions.assertEquals(list1.getProductList().get(0).getReviewCount(), list2.getProductList().get(0).getReviewCount());
        Assertions.assertEquals(list1.getProductList().get(1).getReviewCount(), list2.getProductList().get(1).getReviewCount());
        Assertions.assertEquals(list1.getProductList().get(2).getReviewCount(), list2.getProductList().get(2).getReviewCount());
    }

    @Test
    public void sortingHelperAndSortListReviewCountDescendingTest() {
        ProductComparator newComparator = new ProductReviewCountComparator();

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

        controller1.sortList("descending", "review count");
        controller2.sortingHelper("descending", newComparator);

        Assertions.assertEquals(69, list1.getProductList().get(2).getReviewCount());
        Assertions.assertEquals(150,list1.getProductList().get(1).getReviewCount());
        Assertions.assertEquals(1050, list1.getProductList().get(0).getReviewCount());

        Assertions.assertEquals(69, list2.getProductList().get(2).getReviewCount());
        Assertions.assertEquals(150, list2.getProductList().get(1).getReviewCount());
        Assertions.assertEquals(1050,list2.getProductList().get(0).getReviewCount());

        Assertions.assertEquals(list1.getProductList().get(0).getReviewCount(), list2.getProductList().get(0).getReviewCount());
        Assertions.assertEquals(list1.getProductList().get(1).getReviewCount(), list2.getProductList().get(1).getReviewCount());
        Assertions.assertEquals(list1.getProductList().get(2).getReviewCount(), list2.getProductList().get(2).getReviewCount());
    }

    //review star
    @Test
    public void sortingHelperAndSortListReviewStarAscendingTest() {
        ProductComparator newComparator = new ProductReviewStarComparator();

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
        controller2.sortingHelper("ascending", newComparator);

        Assertions.assertEquals(4.19, list1.getProductList().get(0).getReviewStars());
        Assertions.assertEquals(4.3,list1.getProductList().get(1).getReviewStars());
        Assertions.assertEquals(4.8, list1.getProductList().get(2).getReviewStars());

        Assertions.assertEquals(4.19, list2.getProductList().get(0).getReviewStars());
        Assertions.assertEquals(4.3, list2.getProductList().get(1).getReviewStars());
        Assertions.assertEquals(4.8,list2.getProductList().get(2).getReviewStars());

        Assertions.assertEquals(list1.getProductList().get(0).getReviewStars(), list2.getProductList().get(0).getReviewStars());
        Assertions.assertEquals(list1.getProductList().get(1).getReviewStars(), list2.getProductList().get(1).getReviewStars());
        Assertions.assertEquals(list1.getProductList().get(2).getReviewStars(), list2.getProductList().get(2).getReviewStars());
    }

    @Test
    public void sortingHelperAndSortListReviewStarDescendingTest() {
        ProductComparator newComparator = new ProductReviewStarComparator();

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
        controller2.sortingHelper("descending", newComparator);

        Assertions.assertEquals(4.19, list1.getProductList().get(2).getReviewStars());
        Assertions.assertEquals(4.3,list1.getProductList().get(1).getReviewStars());
        Assertions.assertEquals(4.8, list1.getProductList().get(0).getReviewStars());

        Assertions.assertEquals(4.19, list2.getProductList().get(2).getReviewStars());
        Assertions.assertEquals(4.3, list2.getProductList().get(1).getReviewStars());
        Assertions.assertEquals(4.8,list2.getProductList().get(0).getReviewStars());

        Assertions.assertEquals(list1.getProductList().get(0).getReviewStars(), list2.getProductList().get(0).getReviewStars());
        Assertions.assertEquals(list1.getProductList().get(1).getReviewStars(), list2.getProductList().get(1).getReviewStars());
        Assertions.assertEquals(list1.getProductList().get(2).getReviewStars(), list2.getProductList().get(2).getReviewStars());
    }

    @Test
    public void getProductListTest() {
        Wishlist list1 = new Wishlist("wishlist 1");
        list1.addProduct(myFavDrink);
        list1.addProduct(animeFigure);
        list1.addProduct(plushie);

        ArrayList<Product> testList = new ArrayList<>();
        testList.add(myFavDrink);
        testList.add(animeFigure);
        testList.add(plushie);

        Assertions.assertEquals(list1.getProductList(), testList);

    }
}
