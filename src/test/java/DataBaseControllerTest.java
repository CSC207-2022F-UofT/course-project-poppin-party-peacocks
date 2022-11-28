import DataBase.DataBase;
import DataBase.DataBaseController;
import Entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

public class DataBaseControllerTest {
    ArrayList<Double> priceData = new ArrayList();
    ArrayList<Date> priceDate = new ArrayList<>();
    String testDate = "Fri Nov 18 01:04:05 EST 2022";
    Item plushie = new Item("Plushie", 40.99, 30.00, "www.amazon.com/plushie",
            "Description from amazon (or you write your own)", new String[]{"toys"}, 40.99, new Date(testDate), 0, 0, "www.amazonimage.com/keyboard", "CAD", priceData, priceDate);
    ArrayList<Product> items = new ArrayList<>();
    ArrayList<String> tags = new ArrayList<>();


    @Test
    public void TestDataBaseWritesAndSavesListOfWishLists() {
        DataBaseController dataBaseController = new DataBaseController();
        ListOfWishlists wishlists = new ListOfWishlists();
        Wishlist wishlist = new Wishlist("Exam Celebration Wish List");
        wishlist.setDateAdded(new Date(testDate));
        wishlists.addWishlist(wishlist);

        User user = new User("TestUser", "Test");
        DataBase.saveListOfWishlists(wishlists, user);

        Assertions.assertEquals(dataBaseController.getListOfWishlists("TestUser").getListOfWishlist().get(0).getName(), "Exam Celebration Wish List");
    }

}
