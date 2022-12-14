package DataBase;

import Entities.Product;
import Entities.ProductList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

/** A class that helps the database format item and wishlist data for storage */
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
        productObject.put("itemPrice", product.getProductPrice());
        productObject.put("priceChange", product.getPriceChange());
        productObject.put("desiredPrice", product.getProductDesiredPrice());
        productObject.put("dateAdded", new SimpleDateFormat("E MMM dd HH:mm:ss yyyy").format(product.getProductDateAdded()));
        productObject.put("reviewStars", product.getReviewStars());
        productObject.put("reviewCount", product.getReviewCount());
        productObject.put("imageURL", product.getProductImageURL());

        JSONArray historyDateObject = new JSONArray();
        for (Date date : product.getPriceHistoryDates()) {
            historyDateObject.add(new SimpleDateFormat("E MMM dd HH:mm:ss yyyy").format(date));
        }
        JSONArray historyDataObject = new JSONArray();
        historyDataObject.addAll(product.getPriceHistoryData());

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
    public JSONObject createWishlistJSON(ProductList wishlist) {
        JSONObject wishlistObject = new JSONObject();
        wishlistObject.put("name", wishlist.getName());
        wishlistObject.put("dateAdded", new SimpleDateFormat("E MMM dd HH:mm:ss yyyy").format(wishlist.getDateAdded()));

        JSONArray itemObjects = new JSONArray();
        for (Product item : wishlist.getProductList()) {
            itemObjects.add(createItemJSON(item));
        }

        JSONArray displayedListObject = new JSONArray();
        for (Product item : wishlist.getDisplayedList()) {
            displayedListObject.add(createItemJSON(item));
        }

        wishlistObject.put("itemList", itemObjects);
        wishlistObject.put("displayedList", displayedListObject);

        return wishlistObject;
    }

}

