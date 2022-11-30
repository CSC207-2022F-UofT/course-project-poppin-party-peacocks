package DataBaseTest;

import DataBase.DataBaseFormatter;
import Entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Date;

public class DataBaseFormatterTest {
    ArrayList<Double> priceData = new ArrayList<>();
    ArrayList<Date> priceDate = new ArrayList<>();
    String testDate = "Fri Nov 18 01:04:05 EST 2022";
    Item plushie = new Item("Plushie", 40.99, 30.00, "www.amazon.com/plushie",
            "Description from amazon (or you write your own)", new String[]{"toys"}, 40.99, new Date(testDate), 0, 0, "www.amazonimage.com/keyboard", "CAD", priceData, priceDate);
    ArrayList<Product> items = new ArrayList<>();
    ArrayList<String> tags = new ArrayList<>();

    @Test
    public void TestDataBaseReturnsItemJSON() {
        DataBaseFormatter dataBaseFormatter = new DataBaseFormatter();
        plushie.setDateAdded(new Date(testDate));
        String itemString = dataBaseFormatter.createItemJSON(plushie).toString();
        Assertions.assertTrue(itemString.contains("\"priceChange\":40.99"));
        Assertions.assertTrue(itemString.contains("\"itemName\":\"Plushie\""));
        Assertions.assertTrue(itemString.contains("\"desiredPrice\":30.0"));
        Assertions.assertTrue(itemString.contains("\"reviewCount\":0"));
        Assertions.assertTrue(itemString.contains("\"imageURL\":\"www.amazonimage.com\\/keyboard\""));
        Assertions.assertTrue(itemString.contains("\"itemPrice\":40.99"));
        Assertions.assertTrue(itemString.contains("\"itemDescription\":\"Description from amazon (or you write your own)\""));
        Assertions.assertTrue(itemString.contains("\"reviewStars\":0.0,"));
        Assertions.assertTrue(itemString.contains("\"url\":\"www.amazon.com\\/plushie\""));
    }

    @Test
    public void TestDataBaseReturnsWishListJSON() {
        DataBaseFormatter dataBaseFormatter = new DataBaseFormatter();
        plushie.setDateAdded(new Date(testDate));
        items.add(plushie);
        tags.add("Blue");
        Wishlist wishlist = new Wishlist("Singles Day List", items, items, new Date(testDate), tags);
        String wishlistString = dataBaseFormatter.createWishlistJSON(wishlist).toString();
        Assertions.assertTrue(wishlistString.contains("\"name\":\"Singles Day List\""));
        Assertions.assertTrue(wishlistString.contains("\"displayedList\""));
        Assertions.assertTrue(wishlistString.contains("\"itemList\""));
        Assertions.assertTrue(wishlistString.contains("\"selectedTags\""));
    }
}
