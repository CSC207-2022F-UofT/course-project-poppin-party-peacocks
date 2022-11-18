import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

public class DataBaseTest {
    Item plushie = new Item("Plushie", 40.99, 30.00, "www.amazon.com/plushie",
            "Description from amazon (or you write your own)", new String[]{"toys"}, 0, 0, "www.amazonimage.com/keyboard");
    ArrayList<Item> items = new ArrayList<>();
    ArrayList<String> tags = new ArrayList<>();
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
        plushie.setDateAdded(new Date("Fri Nov 18 01:04:05 EST 2022"));
        Assertions.assertEquals(DataBase.createItemJSON(plushie).toString(), "{\"priceChange\":40.99,\"itemName\":\"Plushie\",\"desiredPrice\":30.0,\"reviewCount\":0,\"imageURL\":\"www.amazonimage.com\\/keyboard\",\"itemPrice\":40.99,\"itemDescription\":\"Description from amazon (or you write your own)\",\"reviewStars\":0.0,\"url\":\"www.amazon.com\\/plushie\",\"dateAdded\":\"Fri Nov 18 01:04:05 EST 2022\",\"tags\":[\"toys\"]}");
    }

    @Test
    public void TestDataBaseParsesItemObject() throws ParseException, java.text.ParseException {
        plushie.setDateAdded(new Date("Fri Nov 18 01:04:05 EST 2022"));
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
        plushie.setDateAdded(new Date("Fri Nov 18 01:04:05 EST 2022"));
        items.add(plushie);
        tags.add("Blue");
        Wishlist wishlist = new Wishlist("Singles Day List", items, items, new Date("Fri Nov 18 01:04:05 EST 2022"), tags);
        Assertions.assertEquals(DataBase.createWishlistJSON(wishlist).toString(), "{\"displayedList\":[{\"priceChange\":40.99,\"itemName\":\"Plushie\",\"desiredPrice\":30.0,\"reviewCount\":0,\"imageURL\":\"www.amazonimage.com\\/keyboard\",\"itemPrice\":40.99,\"itemDescription\":\"Description from amazon (or you write your own)\",\"reviewStars\":0.0,\"url\":\"www.amazon.com\\/plushie\",\"dateAdded\":\"Fri Nov 18 01:04:05 EST 2022\",\"tags\":[\"toys\"]}],\"name\":\"Singles Day List\",\"selectedTags\":[\"Blue\"],\"itemList\":[{\"priceChange\":40.99,\"itemName\":\"Plushie\",\"desiredPrice\":30.0,\"reviewCount\":0,\"imageURL\":\"www.amazonimage.com\\/keyboard\",\"itemPrice\":40.99,\"itemDescription\":\"Description from amazon (or you write your own)\",\"reviewStars\":0.0,\"url\":\"www.amazon.com\\/plushie\",\"dateAdded\":\"Fri Nov 18 01:04:05 EST 2022\",\"tags\":[\"toys\"]}],\"dateAdded\":\"Fri Nov 18 01:04:05 EST 2022\"}");
    }

    @Test
    public void TestDataBaseParsesWishListObject() throws ParseException, java.text.ParseException {
        plushie.setDateAdded(new Date("Fri Nov 18 01:04:05 EST 2022"));
        items.add(plushie);
        tags.add("Blue");
        Wishlist wishlist = new Wishlist("Singles Day List", items, items, new Date("Fri Nov 18 01:04:05 EST 2022"), tags);
        JSONParser jsonParser = new JSONParser();
        JSONObject listObject = (JSONObject) jsonParser.parse("{\"displayedList\":[{\"priceChange\":40.99,\"itemName\":\"Plushie\",\"desiredPrice\":30.0,\"reviewCount\":0,\"imageURL\":\"www.amazonimage.com\\/keyboard\",\"itemPrice\":40.99,\"itemDescription\":\"Description from amazon (or you write your own)\",\"reviewStars\":0.0,\"url\":\"www.amazon.com\\/plushie\",\"dateAdded\":\"Fri Nov 18 01:04:05 EST 2022\",\"tags\":[\"toys\"]}],\"name\":\"Singles Day List\",\"selectedTags\":[\"Blue\"],\"itemList\":[{\"priceChange\":40.99,\"itemName\":\"Plushie\",\"desiredPrice\":30.0,\"reviewCount\":0,\"imageURL\":\"www.amazonimage.com\\/keyboard\",\"itemPrice\":40.99,\"itemDescription\":\"Description from amazon (or you write your own)\",\"reviewStars\":0.0,\"url\":\"www.amazon.com\\/plushie\",\"dateAdded\":\"Fri Nov 18 01:04:05 EST 2022\",\"tags\":[\"toys\"]}],\"dateAdded\":\"Fri Nov 18 01:04:05 EST 2022\"}");
        Wishlist parsedList = DataBase.parseWishlist(listObject);
        Assertions.assertEquals(parsedList.getName(), wishlist.getName());
        Assertions.assertEquals(parsedList.getDateAdded(), wishlist.getDateAdded());
        Assertions.assertEquals(parsedList.getDisplayedList().toArray().length, wishlist.getDisplayedList().toArray().length);
        Assertions.assertArrayEquals(parsedList.getSelectedTags().toArray(), wishlist.getSelectedTags().toArray());
        Assertions.assertEquals(parsedList.getItemList().toArray().length, wishlist.getItemList().toArray().length);

    }
}
