package DataBaseTest;

import DataBase.DataBase;
import DataBase.DataBaseController;
import Entities.ListOfProductLists;
import Entities.ListOfWishlists;
import Entities.User;
import Entities.Wishlist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DataBaseControllerTest {
    String testDate = "Tue. Nov. 29 20:49:30 2022";

    @Test
    public void TestDataBaseWritesAndSavesListOfWishLists() throws ParseException, IOException, org.json.simple.parser.ParseException {
        DataBaseController dataBaseController = new DataBaseController();
        ListOfProductLists wishlists = new ListOfWishlists();
        Wishlist wishlist = new Wishlist("Exam Celebration Wish List");
        wishlist.setDateAdded(new SimpleDateFormat("E MMM dd HH:mm:ss yyyy").parse(testDate));
        wishlists.addWishlist(wishlist);

        User user = new User("TestUser", "Test");
        dataBaseController.saveListOfWishlists(wishlists, user);

        Assertions.assertEquals(dataBaseController.getListOfWishlists("TestUser").getListOfWishlist().get(0).getName(), "Exam Celebration Wish List");
    }

    @Test
    public void TestDataBaseGetsCurrentUser() {
        DataBase.currentUser = new User("Name", "Password");
        DataBaseController dataBaseController = new DataBaseController();

        Assertions.assertEquals(dataBaseController.getCurrentUser().getName(), "Name");
    }

}
