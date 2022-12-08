package DataBaseTest;

import DataBase.DataBaseFormatter;
import Entities.Item;
import Entities.Product;
import Entities.Wishlist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DataBaseFormatterTest {
    ArrayList<Double> priceData = new ArrayList<>();
    ArrayList<Date> priceDate = new ArrayList<>();
    String testDate = "Tue. Nov. 29 20:49:30 2022";
    ArrayList<Product> items = new ArrayList<>();
    ArrayList<String> tags = new ArrayList<>();

    @Test
    public void TestDataBaseReturnsItemJSON() throws ParseException {
        Item plushie = new Item("Plushie", 40.99, 30.00, "www.amazon.com/plushie",
                "Description from amazon (or you write your own)", new String[]{"toys"}, 40.99, new SimpleDateFormat("E MMM dd HH:mm:ss yyyy").parse(testDate), 0, 0, "www.amazonimage.com/keyboard", "CAD", priceData, priceDate);
        DataBaseFormatter dataBaseFormatter = new DataBaseFormatter();
        plushie.setDateAdded(new SimpleDateFormat("E MMM dd HH:mm:ss yyyy").parse(testDate));
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
    public void TestDataBaseReturnsWishListJSON() throws ParseException {
        priceData.add(10.0);
        priceDate.add(new SimpleDateFormat("E MMM dd HH:mm:ss yyyy").parse(testDate));
        Item plushie = new Item("Plushie", 40.99, 30.00, "www.amazon.com/plushie",
                "Description from amazon (or you write your own)", new String[]{"toys"}, 40.99, new SimpleDateFormat("E MMM dd HH:mm:ss yyyy").parse(testDate), 0, 0, "www.amazonimage.com/keyboard", "CAD", priceData, priceDate);
        DataBaseFormatter dataBaseFormatter = new DataBaseFormatter();
        plushie.setDateAdded( new SimpleDateFormat("E MMM dd HH:mm:ss yyyy").parse(testDate));
        items.add(plushie);
        tags.add("Blue");
        Wishlist wishlist = new Wishlist("Singles Day List", items, items,  new SimpleDateFormat("E MMM dd HH:mm:ss yyyy").parse(testDate));
        String wishlistString = dataBaseFormatter.createWishlistJSON(wishlist).toString();
        Assertions.assertTrue(wishlistString.contains("\"name\":\"Singles Day List\""));
        Assertions.assertTrue(wishlistString.contains("\"displayedList\""));
        Assertions.assertTrue(wishlistString.contains("\"itemList\""));
        Assertions.assertTrue(wishlistString.contains("\"selectedTags\""));
    }
}
