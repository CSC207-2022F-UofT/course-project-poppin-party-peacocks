package Entities;

import java.util.ArrayList;
import java.util.Date;

public interface Product {
    public String getProductName();
    public String getProductDescription();
    public String getProductURL();
    public String getProductImageURL();
    public double getProductPrice();
    public double getPriceChange();
    public double getProductDesiredPrice();
    public Date getProductDateAdded();
    public String[] getTags();
    public ArrayList<Double> getPriceHistoryData();
    public ArrayList<Date> getPriceHistoryDates();
    public String getProductCurrency();
    public void setName(String newName);
    public void setDateAdded(Date date);
    public void setProductDescription(String description);
    public void setPriceChange(Double priceChange);
    public void setDesiredPrice(double newDesiredPrice);
    public void setPriceHistoryData(ArrayList<Double> updatedPrices);
    public void setPriceHistoryDates(ArrayList<Date> updatedDates);
    public void setReviewStars(double newReviewStars);
    public double getReviewStars();
    public void setReviewCount(int reviewCount);
    public int getReviewCount();
}
