import DataBase.DataBase;
import DataBase.DataBaseController;
import Entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

public class DataBaseControllerTest {
    String testDate = "Fri Nov 18 01:04:05 EST 2022";

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

    @Test
    public void TestDataBaseGetsCurrentUser() {
        DataBase.currentUser = new User("Name", "Password");
        DataBaseController dataBaseController = new DataBaseController();

        Assertions.assertEquals(dataBaseController.getCurrentUser().getName(), "Name");
    }

}
