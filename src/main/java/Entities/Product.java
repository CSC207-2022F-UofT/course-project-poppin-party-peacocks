package Entities;

import java.util.ArrayList;
import java.util.Date;

/**
 * An interface that specifies the functionalities expected from a product
 */
public interface Product {
    /** returns the name of the Product*/
    String getProductName();
    /** returns the product description of the Product*/
    String getProductDescription();
    /** returns the url of the Product*/
    String getProductURL();
    /** returns the image url of the Product*/
    String getProductImageURL();
    /** returns the price of the Product*/
    double getProductPrice();
    /** returns the price of the Product as a string*/
    String getProductPriceString();
    /** returns the difference of new price and current price of the Product*/
    double getPriceChange();
    /** returns the desired price of the Product*/
    double getProductDesiredPrice();
    /** returns the date added of the Product*/
    Date getProductDateAdded();
    /** returns the history of price points of the Product in an ArrayList*/
    ArrayList<Double> getPriceHistoryData();
    /** returns the dates of price points of the Product in an ArrayList*/
    ArrayList<Date> getPriceHistoryDates();
    /** returns the currency of the Product as a string*/
    String getProductCurrency();
    /** sets a new name for the Product*/
    void setName(String newName);
    /** sets a new date added for the Product*/
    void setDateAdded(Date date);
    /** sets a new product description for the Product*/
    void setProductDescription(String description);
    /** sets a new price for the Product*/
    void setPriceChange(Double priceChange);
    /** sets a new desired price for the Product*/
    void setDesiredPrice(double newDesiredPrice);
    /** sets a new ArrayList of prices history for the Product*/
    void setPriceHistoryData(ArrayList<Double> updatedPrices);
    /** sets a new ArrayList of dates for price history for the Product*/
    void setPriceHistoryDates(ArrayList<Date> updatedDates);
    /** sets a new amount of review stars for the Product*/
    void setReviewStars(double newReviewStars);
    /** returns the review stars for the Product*/
    double getReviewStars();
    /** sets a new amount of review count for the Product*/
    void setReviewCount(int reviewCount);
    /** returns the review count for the Product*/
    int getReviewCount();
    /** sets the price for the Product*/
    void setProductPrice(double newPrice);
    /** sets the currency that the Product is using as a string*/
    void setProductCurrency(String newCurrency);
    /** returns the date when the product was last updated*/
    Date getProductDateLastUpdated();
}
