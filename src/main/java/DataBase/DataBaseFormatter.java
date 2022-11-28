package DataBase;

import Entities.Product;
import Entities.Wishlist;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Arrays;
import java.util.Date;

public class DataBaseFormatter {
    /** Creates an item in JSON format
     * @param product item to convert to json format
     * @returns item in json format
     * */
    // JSONArray's library has errors, can ignore
    @SuppressWarnings("unchecked")
    public JSONObject createItemJSON(Product product) {
        JSONObject productObject = new JSONObject();
        productObject.put("itemName", product.getProductName());
        productObject.put("url", product.getProductURL());
        productObject.put("itemDescription", product.getProductDescription());
        JSONArray tagsObject = new JSONArray();
        tagsObject.addAll(Arrays.asList(product.getTags()));
        productObject.put("tags", tagsObject);
        productObject.put("itemPrice", product.getProductPrice());
        productObject.put("priceChange", product.getPriceChange());
        productObject.put("desiredPrice", product.getProductDesiredPrice());
        productObject.put("dateAdded", product.getProductDateAdded().toString());
        productObject.put("reviewStars", product.getReviewStars());
        productObject.put("reviewCount", product.getReviewCount());
        productObject.put("imageURL", product.getProductImageURL());

        JSONArray historyDateObject = new JSONArray();
        for (Date date : product.getPriceHistoryDates()) {
            historyDateObject.add(date.toString());
        }
        JSONArray historyDataObject = new JSONArray();
        tagsObject.addAll(Arrays.asList(product.getPriceHistoryData()));

        productObject.put("historyDate", historyDateObject);
        productObject.put("historyData", historyDataObject);
        productObject.put("currency", product.getProductCurrency());

        return productObject;
    }

    /** Creates a wishlist in JSON format
     * @param wishlist wishlist to convert to json format
     * @returns wishlist in json format
     * */
    // JSONArray's library has errors, can ignore
    @SuppressWarnings("unchecked")
    public JSONObject createWishlistJSON(Wishlist wishlist) {
        JSONObject wishlistObject = new JSONObject();
        wishlistObject.put("name", wishlist.getName());
        wishlistObject.put("dateAdded", wishlist.getDateAdded().toString());

        JSONArray itemObjects = new JSONArray();
        for (Product item : wishlist.getItemList()) {
            itemObjects.add(createItemJSON(item));
        }

        JSONArray displayedListObject = new JSONArray();
        for (Product item : wishlist.getDisplayedList()) {
            displayedListObject.add(createItemJSON(item));
        }

        JSONArray selectedTagsObject = new JSONArray();
        selectedTagsObject.addAll(wishlist.getSelectedTags());
        wishlistObject.put("itemList", itemObjects);
        wishlistObject.put("displayedList", displayedListObject);
        wishlistObject.put("selectedTags", selectedTagsObject);

        return wishlistObject;
    }

}
