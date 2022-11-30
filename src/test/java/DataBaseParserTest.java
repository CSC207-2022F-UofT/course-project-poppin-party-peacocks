import DataBase.DataBaseParser;
import Entities.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

public class DataBaseParserTest {
    ArrayList<Double> priceData = new ArrayList<>();
    ArrayList<Date> priceDate = new ArrayList<>();
    String testDate = "Fri Nov 18 01:04:05 EST 2022";
    Item plushie = new Item("Plushie", 40.99, 30.00, "www.amazon.com/plushie",
            "Description from amazon (or you write your own)", new String[]{"toys"}, 40.99, new Date(testDate), 0, 0, "www.amazonimage.com/keyboard", "CAD", priceData, priceDate);
    ArrayList<Product> items = new ArrayList<>();
    ArrayList<String> tags = new ArrayList<>();

    @Test
    public void TestDataBaseParsesItemObject() throws ParseException, java.text.ParseException {
        DataBaseParser dataBaseParser = new DataBaseParser();
        plushie.setDateAdded(new Date(testDate));
        JSONParser jsonParser = new JSONParser();
        JSONObject itemObject = (JSONObject) jsonParser.parse("{\"priceChange\":40.99,\"itemName\":\"Plushie\",\"desiredPrice\":30.0,\"reviewCount\":0,\"imageURL\":\"www.amazonimage.com\\/keyboard\",\"itemPrice\":40.99,\"itemDescription\":\"Description from amazon (or you write your own)\",\"reviewStars\":0.0,\"url\":\"www.amazon.com\\/plushie\",\"dateAdded\":\"Fri Nov 18 01:04:05 EST 2022\",\"tags\":[\"toys\"]}");
        Product parsedItem = dataBaseParser.parseItem(itemObject);
        Assertions.assertEquals(parsedItem.getProductDescription(), plushie.getProductDescription());
        Assertions.assertEquals(parsedItem.getProductPrice(), plushie.getProductPrice());
        Assertions.assertEquals(parsedItem.getProductName(), plushie.getProductName());
        Assertions.assertEquals(parsedItem.getProductURL(), plushie.getProductURL());
        Assertions.assertEquals(parsedItem.getProductDesiredPrice(), plushie.getProductDesiredPrice());
        Assertions.assertArrayEquals(parsedItem.getTags(), plushie.getTags());
        Assertions.assertEquals(parsedItem.getPriceChange(), plushie.getPriceChange());
        Assertions.assertEquals(parsedItem.getProductImageURL(), plushie.getProductImageURL());
        Assertions.assertEquals(parsedItem.getReviewCount(), plushie.getReviewCount());
        Assertions.assertEquals(parsedItem.getReviewStars(), plushie.getReviewStars());
        Assertions.assertEquals(parsedItem.getProductDateAdded(), plushie.getProductDateAdded());
    }

    @Test
    public void TestDataBaseParsesWishListObject() throws ParseException, java.text.ParseException {
        DataBaseParser dataBaseParser = new DataBaseParser();
        plushie.setDateAdded(new Date(testDate));
        items.add(plushie);
        tags.add("Blue");
        Wishlist wishlist = new Wishlist("Singles Day List", items, items, new Date(testDate), tags);
        JSONParser jsonParser = new JSONParser();
        JSONObject listObject = (JSONObject) jsonParser.parse("{\"displayedList\":[{\"priceChange\":40.99,\"itemName\":\"Plushie\",\"desiredPrice\":30.0,\"reviewCount\":0,\"imageURL\":\"www.amazonimage.com\\/keyboard\",\"itemPrice\":40.99,\"itemDescription\":\"Description from amazon (or you write your own)\",\"reviewStars\":0.0,\"url\":\"www.amazon.com\\/plushie\",\"dateAdded\":\"Fri Nov 18 01:04:05 EST 2022\",\"tags\":[\"toys\"]}],\"name\":\"Singles Day List\",\"selectedTags\":[\"Blue\"],\"itemList\":[{\"priceChange\":40.99,\"itemName\":\"Plushie\",\"desiredPrice\":30.0,\"reviewCount\":0,\"imageURL\":\"www.amazonimage.com\\/keyboard\",\"itemPrice\":40.99,\"itemDescription\":\"Description from amazon (or you write your own)\",\"reviewStars\":0.0,\"url\":\"www.amazon.com\\/plushie\",\"dateAdded\":\"Fri Nov 18 01:04:05 EST 2022\",\"tags\":[\"toys\"]}],\"dateAdded\":\"Fri Nov 18 01:04:05 EST 2022\"}");
        Wishlist parsedList = dataBaseParser.parseWishlist(listObject);
        Assertions.assertEquals(parsedList.getName(), wishlist.getName());
        Assertions.assertEquals(parsedList.getDateAdded(), wishlist.getDateAdded());
        Assertions.assertEquals(parsedList.getDisplayedList().toArray().length, wishlist.getDisplayedList().toArray().length);
        Assertions.assertArrayEquals(parsedList.getSelectedTags().toArray(), wishlist.getSelectedTags().toArray());
        Assertions.assertEquals(parsedList.getProductList().toArray().length, wishlist.getProductList().toArray().length);
    }
}
