package Entities;

import java.util.ArrayList;
import java.util.Date;

/**
 * An interface that specifies the functionalities expected from a product
 */
public interface Product {
    String getProductName();
    String getProductDescription();
    String getProductURL();
    String getProductImageURL();
    double getProductPrice();
    String getProductPriceString();
    double getPriceChange();
    double getProductDesiredPrice();
    Date getProductDateAdded();
    String[] getTags();
    ArrayList<Double> getPriceHistoryData();
    ArrayList<Date> getPriceHistoryDates();
    String getProductCurrency();
    void setName(String newName);
    void setDateAdded(Date date);
    void setProductDescription(String description);
    void setPriceChange(Double priceChange);
    void setDesiredPrice(double newDesiredPrice);
    void setPriceHistoryData(ArrayList<Double> updatedPrices);
    void setPriceHistoryDates(ArrayList<Date> updatedDates);
    void setReviewStars(double newReviewStars);
    double getReviewStars();
    void setReviewCount(int reviewCount);
    int getReviewCount();
    void setProductPrice(double newPrice);
    void setProductCurrency(String newCurrency);

    Date getProductDateLastUpdated();
}
