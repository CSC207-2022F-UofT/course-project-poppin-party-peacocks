package DataBase;

import Entities.Item;
import Entities.Product;
import Entities.Wishlist;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/** A class that helps parses JSON data from the database */
public class DataBaseParser {
    /** Parses a wishlist in JSON format
     * @param wishlistObject wishlist to convert to wish list object
     * @return wishlist object
     * */
    public Wishlist parseWishlist(Object wishlistObject) throws java.text.ParseException {
        JSONObject wishlistData = (JSONObject) wishlistObject;
        String name = (String) wishlistData.get("name");

        Date dateAdded =  new SimpleDateFormat("E MMM dd HH:mm:ss yyyy").parse(wishlistData.get("dateAdded").toString());
        new Date().;
        ArrayList<Product> items = new ArrayList<>();
        JSONArray itemsObjects = (JSONArray) wishlistData.get("itemList");
        if (!Objects.isNull(itemsObjects)) {
            for (Object itemObject : itemsObjects) {
                items.add(parseItem(itemObject));
            }
        }

        ArrayList<Product> displayedItems = new ArrayList<>();
        JSONArray itemObjects = (JSONArray) wishlistData.get("displayedList");
        if (!Objects.isNull(itemObjects)) {
            for (Object itemObject : (JSONArray) wishlistData.get("displayedList")) {
                displayedItems.add(parseItem(itemObject));
            }
        }

        ArrayList<String> tags = new ArrayList<>();
        JSONArray tagObjects = (JSONArray) wishlistData.get("selectedTags");
        if (!Objects.isNull(tagObjects)) {
            for (Object tagObject : tagObjects) {
                tags.add(tagObject.toString());
            }
        }

       return new Wishlist(name, items, displayedItems, dateAdded, tags);
    }

    /** Parses an item in JSON format
     * @param itemObject item to parse
     * @returns item object
     * */
    public Product parseItem(Object itemObject) throws java.text.ParseException {
        JSONObject itemData = (JSONObject) itemObject;
        String itemName = (String) itemData.get("itemName");
        String url = (String) itemData.get("url");
        String itemDescription = (String) itemData.get("itemDescription");

        Double itemPrice = (Double) itemData.get("itemPrice");
        Double priceChange = (Double) itemData.get("priceChange");
        Double desiredPrice = (Double) itemData.get("desiredPrice");

        Date dateAdded =  new SimpleDateFormat("E MMM dd HH:mm:ss yyyy").parse(itemData.get("dateAdded").toString());

        ArrayList<String> tags = new ArrayList<>();
        JSONArray tagsObject = (JSONArray) itemData.get("tags");
        if (!Objects.isNull(tagsObject)) {
            for (Object tag : tagsObject) {
                tags.add(tag.toString());
            }
        }

        String[] tagsArray = new String[tags.size()];
        for (int i = 0; i < tags.size(); i++) {
            tagsArray[i] = tags.get(i);
        }
        Double reviewStars = (Double) itemData.get("reviewStars");
        int reviewCount = Integer.parseInt(itemData.get("reviewCount").toString());
        String imageURL = (String) itemData.get("imageURL");

        ArrayList<Date> historyDates = new ArrayList<>();

        JSONArray historyDatesObject = (JSONArray) itemData.get("historyDate");
        if (!Objects.isNull(historyDatesObject)) {
            for (Object date : historyDatesObject) {
                historyDates.add(new SimpleDateFormat("E MMM dd HH:mm:ss yyyy").parse(date.toString()));
            }
        }

        ArrayList<Double> historyData = new ArrayList<>();
        JSONArray historyDataObject = (JSONArray) itemData.get("historyData");
        if (!Objects.isNull(historyDataObject)) {
            for (Object price : historyDataObject) {
                historyData.add(Double.parseDouble(price.toString()));
            }
        }

        String currency = (String) itemData.get("currency");
        return new Item(itemName, itemPrice, desiredPrice, url, itemDescription, tagsArray, priceChange, dateAdded, reviewCount, reviewStars, imageURL, currency, historyData, historyDates);
    }

}
