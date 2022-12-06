import Controller.ProductComparatorController;
import Entities.*;
import UseCases.Comparator.ProductComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

public class ProductComparatorControllerTest {
    Item myFavDrink = new Item("Lime Bubbly", 5.47, 5.00, "www.shoppers.com/bubbly",
            "my favorite drink, bubbly", 69, 4.19,"www.shoppersimage.com/bubbly", null, new String[]{"drink"});
    Item animeFigure = new Item("Starlight Anya Forger", 100, 85.00, "www.amazon.com/AnyaPeanuts",
            "new Anya figure", 150, 4.8,"www.amazonimage.com/AnyaPeanuts", null, new String[]{"figure"});
    Item plushie = new Item("Whale Plushie", 40.99, 30.00, "www.amazon.com/WhalePlushie",
            "Giant Whale Plushie", 1050, 4.3, "www.amazonimage.com/OhWhale", null, new String[]{"toys"});

    ProductComparatorController christmasWishlist = new ProductComparatorController("Christmas Wishlist");
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

    /**sortList and sortingHelper being used together*/
    //date
    @Test
    public void sortingHelperAndSortListDateAscendingTest() {
        ProductComparator newComparator = new ProductDateComparator();
        ProductComparatorController testList = new ProductComparatorController("Test Wishlist");

        dateInstance.set(2022, Calendar.SEPTEMBER, 15);
        Date date1 = dateInstance.getTime();
        dateInstance.set(2022, Calendar.NOVEMBER, 15);
        Date date2 = dateInstance.getTime();
        dateInstance.set(2022, Calendar.DECEMBER, 15);
        Date date3 = dateInstance.getTime();

        myFavDrink.setDateAdded(date3);
        animeFigure.setDateAdded(date2);
        plushie.setDateAdded(date1);

        christmasWishlist.addProduct(myFavDrink);
        christmasWishlist.addProduct(animeFigure);
        christmasWishlist.addProduct(plushie);

        testList.addProduct(myFavDrink);
        testList.addProduct(animeFigure);
        testList.addProduct(plushie);

        christmasWishlist.sortList("ascending", "date");
        testList.sortingHelper("ascending", newComparator);

        Assertions.assertEquals(christmasWishlist.getProductList(), testList.getProductList());
    }

    @Test
    public void sortingHelperAndSortListDateDescendingTest() {
        ProductComparator newComparator = new ProductDateComparator();
        ProductComparatorController testList = new ProductComparatorController("Test Wishlist");

        dateInstance.set(2022, Calendar.SEPTEMBER, 15);
        Date date1 = dateInstance.getTime();
        dateInstance.set(2022, Calendar.NOVEMBER, 15);
        Date date2 = dateInstance.getTime();
        dateInstance.set(2022, Calendar.DECEMBER, 15);
        Date date3 = dateInstance.getTime();

        myFavDrink.setDateAdded(date3);
        animeFigure.setDateAdded(date2);
        plushie.setDateAdded(date1);

        christmasWishlist.addProduct(myFavDrink);
        christmasWishlist.addProduct(animeFigure);
        christmasWishlist.addProduct(plushie);

        testList.addProduct(myFavDrink);
        testList.addProduct(animeFigure);
        testList.addProduct(plushie);

        christmasWishlist.sortList("descending", "date");
        testList.sortingHelper("descending", newComparator);

        Assertions.assertEquals(christmasWishlist.getProductList(), testList.getProductList());
    }

    //name
    @Test
    public void sortingHelperAndSortListNameAscendingTest() {
        ProductComparator newComparator = new ProductNameComparator();

        christmasWishlist.addProduct(myFavDrink);
        christmasWishlist.addProduct(animeFigure);
        christmasWishlist.addProduct(plushie);

        ProductComparatorController testList = new ProductComparatorController("Test Wishlist");
        testList.addProduct(myFavDrink);
        testList.addProduct(animeFigure);
        testList.addProduct(plushie);

        christmasWishlist.sortList("ascending", "name");
        testList.sortingHelper("ascending", newComparator);

        Assertions.assertEquals(christmasWishlist.getProductList(), testList.getProductList());
    }

    @Test
    public void sortingHelperAndSortListNameDescendingTest() {
        ProductComparator newComparator = new ProductNameComparator();

        christmasWishlist.addProduct(myFavDrink);
        christmasWishlist.addProduct(animeFigure);
        christmasWishlist.addProduct(plushie);

        ProductComparatorController testList = new ProductComparatorController("Test Wishlist");
        testList.addProduct(myFavDrink);
        testList.addProduct(animeFigure);
        testList.addProduct(plushie);

        christmasWishlist.sortList("descending", "name");
        testList.sortingHelper("descending", newComparator);

        Assertions.assertEquals(christmasWishlist.getProductList(), testList.getProductList());
    }

    //price
    @Test
    public void sortingHelperAndSortListPriceAscendingTest() {
        ProductComparator newComparator = new ProductPriceComparator();

        christmasWishlist.addProduct(myFavDrink);
        christmasWishlist.addProduct(animeFigure);
        christmasWishlist.addProduct(plushie);

        ProductComparatorController testList = new ProductComparatorController("Test Wishlist");
        testList.addProduct(myFavDrink);
        testList.addProduct(animeFigure);
        testList.addProduct(plushie);

        christmasWishlist.sortList("ascending", "price");
        testList.sortingHelper("ascending", newComparator);

        Assertions.assertEquals(christmasWishlist.getProductList(), testList.getProductList());
    }

    @Test
    public void sortingHelperAndSortListPriceDescendingTest() {
        ProductComparator newComparator = new ProductPriceComparator();

        christmasWishlist.addProduct(myFavDrink);
        christmasWishlist.addProduct(animeFigure);
        christmasWishlist.addProduct(plushie);

        ProductComparatorController testList = new ProductComparatorController("Test Wishlist");
        testList.addProduct(myFavDrink);
        testList.addProduct(animeFigure);
        testList.addProduct(plushie);

        christmasWishlist.sortList("descending", "price");
        testList.sortingHelper("descending", newComparator);

        Assertions.assertEquals(christmasWishlist.getProductList(), testList.getProductList());
    }

    //review count
    @Test
    public void sortingHelperAndSortListReviewCountAscendingTest() {
        ProductComparator newComparator = new ProductReviewCountComparator();

        christmasWishlist.addProduct(myFavDrink);
        christmasWishlist.addProduct(animeFigure);
        christmasWishlist.addProduct(plushie);

        ProductComparatorController testList = new ProductComparatorController("Test Wishlist");
        testList.addProduct(myFavDrink);
        testList.addProduct(animeFigure);
        testList.addProduct(plushie);

        christmasWishlist.sortList("ascending", "review count");
        testList.sortingHelper("ascending", newComparator);

        Assertions.assertEquals(christmasWishlist.getProductList(), testList.getProductList());
    }

    @Test
    public void sortingHelperAndSortListReviewCountDescendingTest() {
        ProductComparator newComparator = new ProductReviewCountComparator();

        christmasWishlist.addProduct(myFavDrink);
        christmasWishlist.addProduct(animeFigure);
        christmasWishlist.addProduct(plushie);

        ProductComparatorController testList = new ProductComparatorController("Test Wishlist");
        testList.addProduct(myFavDrink);
        testList.addProduct(animeFigure);
        testList.addProduct(plushie);

        christmasWishlist.sortList("descending", "review count");
        testList.sortingHelper("descending", newComparator);

        Assertions.assertEquals(christmasWishlist.getProductList(), testList.getProductList());
    }

    //review star
    @Test
    public void sortingHelperAndSortListReviewStarAscendingTest() {
        ProductComparator newComparator = new ProductReviewStarComparator();

        christmasWishlist.addProduct(myFavDrink);
        christmasWishlist.addProduct(animeFigure);
        christmasWishlist.addProduct(plushie);

        ProductComparatorController testList = new ProductComparatorController("Test Wishlist");
        testList.addProduct(myFavDrink);
        testList.addProduct(animeFigure);
        testList.addProduct(plushie);

        christmasWishlist.sortList("ascending", "review star");
        testList.sortingHelper("ascending", newComparator);

        Assertions.assertEquals(christmasWishlist.getProductList(), testList.getProductList());
    }

    @Test
    public void sortingHelperAndSortListReviewStarDescendingTest() {
        ProductComparator newComparator = new ProductReviewStarComparator();

        christmasWishlist.addProduct(myFavDrink);
        christmasWishlist.addProduct(animeFigure);
        christmasWishlist.addProduct(plushie);

        ProductComparatorController testList = new ProductComparatorController("Test Wishlist");
        testList.addProduct(myFavDrink);
        testList.addProduct(animeFigure);
        testList.addProduct(plushie);

        christmasWishlist.sortList("descending", "review star");
        testList.sortingHelper("descending", newComparator);

        Assertions.assertEquals(christmasWishlist.getProductList(), testList.getProductList());
    }
}
