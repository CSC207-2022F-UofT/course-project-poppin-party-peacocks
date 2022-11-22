import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Entities.*;
import DataBase.*;
import java.util.ArrayList;
import java.util.Date;

public class DataBaseTest {
    Item plushie = new Item("Plushie", 40.99, 30.00, "www.amazon.com/plushie",
            "Description from amazon (or you write your own)", new String[]{"toys"}, 0, 0, "www.amazonimage.com/keyboard");
    ArrayList<Item> items = new ArrayList<>();
    ArrayList<String> tags = new ArrayList<>();
    String testDate = "Fri Nov 18 01:04:05 EST 2022";
    @Test
    public void TestDataBaseReturnsUserFilePath() {
        Assertions.assertEquals(DataBase.getUserFilePath(), "src/main/database/users.txt");
    }

    @Test
    public void TestDataBaseReturnsWishListPath() {
        Assertions.assertEquals(DataBase.getWishlistPath("Herman1"), "src/main/database/Herman1.txt");
    }

    @Test
    public void TestDataBaseReturnsItemJSON() {
        plushie.setDateAdded(new Date(testDate));
        String itemString = DataBase.createItemJSON(plushie).toString();
        Assertions.assertTrue(itemString.contains("\"priceChange\":40.99"));
        Assertions.assertTrue(itemString.contains("\"itemName\":\"Plushie\""));
        Assertions.assertTrue(itemString.contains("\"desiredPrice\":30.0"));
        Assertions.assertTrue(itemString.contains("\"reviewCount\":0"));
        Assertions.assertTrue(itemString.contains("\"imageURL\":\"www.amazonimage.com\\/keyboard\""));
        Assertions.assertTrue(itemString.contains("\"itemPrice\":40.99"));
        Assertions.assertTrue(itemString.contains("\"itemDescription\":\"Description from amazon (or you write your own)\""));
        Assertions.assertTrue(itemString.contains("\"reviewStars\":0.0,"));
        Assertions.assertTrue(itemString.contains("\"url\":\"www.amazon.com\\/plushie\""));
        Assertions.assertTrue(itemString.contains("\"tags\":[\"toys\"]"));
    }

    @Test
    public void TestDataBaseParsesItemObject() throws ParseException, java.text.ParseException {
        plushie.setDateAdded(new Date(testDate));
        JSONParser jsonParser = new JSONParser();
        JSONObject itemObject = (JSONObject) jsonParser.parse("{\"priceChange\":40.99,\"itemName\":\"Plushie\",\"desiredPrice\":30.0,\"reviewCount\":0,\"imageURL\":\"www.amazonimage.com\\/keyboard\",\"itemPrice\":40.99,\"itemDescription\":\"Description from amazon (or you write your own)\",\"reviewStars\":0.0,\"url\":\"www.amazon.com\\/plushie\",\"dateAdded\":\"Fri Nov 18 01:04:05 EST 2022\",\"tags\":[\"toys\"]}");
        Item parsedItem = DataBase.parseItem(itemObject);
        Assertions.assertEquals(parsedItem.getItemDescription(), plushie.getItemDescription());
        Assertions.assertEquals(parsedItem.getItemPrice(), plushie.getItemPrice());
        Assertions.assertEquals(parsedItem.getItemName(), plushie.getItemName());
        Assertions.assertEquals(parsedItem.getItemURL(), plushie.getItemURL());
        Assertions.assertEquals(parsedItem.getItemDesiredPrice(), plushie.getItemDesiredPrice());
        Assertions.assertArrayEquals(parsedItem.getTags(), plushie.getTags());
        Assertions.assertEquals(parsedItem.getPriceChange(), plushie.getPriceChange());
        Assertions.assertEquals(parsedItem.getItemImageURL(), plushie.getItemImageURL());
        Assertions.assertEquals(parsedItem.getReviewCount(), plushie.getReviewCount());
        Assertions.assertEquals(parsedItem.getReviewStars(), plushie.getReviewStars());
        Assertions.assertEquals(parsedItem.getItemDateAdded(), plushie.getItemDateAdded());
    }
    @Test
    public void TestDataBaseReturnsWishListJSON() {
        plushie.setDateAdded(new Date(testDate));
        items.add(plushie);
        tags.add("Blue");
        Wishlist wishlist = new Wishlist("Singles Day List", items, items, new Date(testDate), tags);
        String wishlistString = DataBase.createWishlistJSON(wishlist).toString();
        Assertions.assertTrue(wishlistString.contains("\"name\":\"Singles Day List\""));
        Assertions.assertTrue(wishlistString.contains("\"displayedList\""));
        Assertions.assertTrue(wishlistString.contains("\"itemList\""));
        Assertions.assertTrue(wishlistString.contains("\"selectedTags\""));
    }

    @Test
    public void TestDataBaseParsesWishListObject() throws ParseException, java.text.ParseException {
        plushie.setDateAdded(new Date(testDate));
        items.add(plushie);
        tags.add("Blue");
        Wishlist wishlist = new Wishlist("Singles Day List", items, items, new Date(testDate), tags);
        JSONParser jsonParser = new JSONParser();
        JSONObject listObject = (JSONObject) jsonParser.parse("{\"displayedList\":[{\"priceChange\":40.99,\"itemName\":\"Plushie\",\"desiredPrice\":30.0,\"reviewCount\":0,\"imageURL\":\"www.amazonimage.com\\/keyboard\",\"itemPrice\":40.99,\"itemDescription\":\"Description from amazon (or you write your own)\",\"reviewStars\":0.0,\"url\":\"www.amazon.com\\/plushie\",\"dateAdded\":\"Fri Nov 18 01:04:05 EST 2022\",\"tags\":[\"toys\"]}],\"name\":\"Singles Day List\",\"selectedTags\":[\"Blue\"],\"itemList\":[{\"priceChange\":40.99,\"itemName\":\"Plushie\",\"desiredPrice\":30.0,\"reviewCount\":0,\"imageURL\":\"www.amazonimage.com\\/keyboard\",\"itemPrice\":40.99,\"itemDescription\":\"Description from amazon (or you write your own)\",\"reviewStars\":0.0,\"url\":\"www.amazon.com\\/plushie\",\"dateAdded\":\"Fri Nov 18 01:04:05 EST 2022\",\"tags\":[\"toys\"]}],\"dateAdded\":\"Fri Nov 18 01:04:05 EST 2022\"}");
        Wishlist parsedList = DataBase.parseWishlist(listObject);
        Assertions.assertEquals(parsedList.getName(), wishlist.getName());
        Assertions.assertEquals(parsedList.getDateAdded(), wishlist.getDateAdded());
        Assertions.assertEquals(parsedList.getDisplayedList().toArray().length, wishlist.getDisplayedList().toArray().length);
        Assertions.assertArrayEquals(parsedList.getSelectedTags().toArray(), wishlist.getSelectedTags().toArray());
        Assertions.assertEquals(parsedList.getItemList().toArray().length, wishlist.getItemList().toArray().length);
    }

    @Test
    public void TestDataBaseWritesAndSavesListOfWishLists() {
        ListOfWishlists wishlists = new ListOfWishlists();
        Wishlist wishlist = new Wishlist("Exam Celebration Wish List");
        wishlist.setDateAdded(new Date(testDate));
        wishlists.addWishlist(wishlist);

        User user = new User("TestUser", "Test");
        DataBase.saveListOfWishlists(wishlists, user);
        System.out.println(DataBase.getListOfWishlists("TestUser").getListOfWishlist().get(0));

        Assertions.assertEquals(DataBase.getListOfWishlists("TestUser").getListOfWishlist().get(0).getName(), "Exam Celebration Wish List");
    }

}
