import Entities.*;
import Entities.Scheduler;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class GeneratePriceHistoryUseCase {
    public Item item;
    private Scheduler scheduler;
    DecimalFormat formatter = new DecimalFormat("#.##");

    public GeneratePriceHistoryUseCase(Item item) {
        this.item = item;
        TimerTask t = new TimerTask() {
            @Override
            public void run() {
                updatePriceHistoryData(item);
            }
        };
        this.scheduler = new Scheduler(t, 1000 * 60 * 60 * 24);
    }

    /**
     * Adds the daily updated price of an item to its priceHistoryData
     *
     * @param item the item whose priceHistoryData will be updated
     */
    public void updatePriceHistoryData(Item item) {
        ArrayList<Double> updatedPriceHistoryData = item.getPriceHistoryData();
        ArrayList<Date> updatedPriceHistoryDates = item.getPriceHistoryDates();
        updatedPriceHistoryData.add(item.getItemPrice());
        updatedPriceHistoryDates.add(new Date());
        item.setPriceHistoryData(updatedPriceHistoryData);
        item.setPriceHistoryDates(updatedPriceHistoryDates);

    }

    /**
     * Creates and returns an array of all the dates ranging from the item's date-added to the date of the last
     * updatePrice call, in yyyy-MM-dd format.
     *
     * @return the array of all dates since the date the item was added
     * @throws ParseException a date parse exception
     */
    public String[] formatPriceHistoryXAxisForGraphing() throws ParseException {
        ArrayList<Date> priceDates = item.getPriceHistoryDates();
        String[] dates = new String[priceDates.size()];

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < priceDates.size(); i++){
            dates[i] = dateFormatter.format(priceDates.get(i));
        }

        return dates;
    }

    /**
     * Creates and returns an array version of all the prices in the item's priceHistory (allows redundant values
     * if the price did not change on some days)
     *
     * @return the array of the item's prices each day since the item was added
     */
    public Double[] formatPriceHistoryYAxisForGraphing() {
        ArrayList<Double> priceData = item.getPriceHistoryData();
        Double[] prices = new Double[priceData.size()];

        for (int i = 0; i < prices.length; i++) {
            prices[i] = priceData.get(i);
        }

        return prices;
    }

    /**
     * Helper method for turning time period inputs to number of days. Returns -1 for invalid input.
     * @param timePeriod the specified time period
     * @param item the item that the time period methods will be applied to
     * @return the approximate number of days in the specified time period or -1 for invalid inputs
     */
    public int convertValidTimePeriodToDaysHelper(String timePeriod, Item item){
        int numDays = 0;
        switch (timePeriod) {
            case "24 hours":
                numDays = 1;
                break;
            case "1 week":
                numDays = 7;
                break;
            case "30 days":
                numDays = 30;
                break;
            case "6 months":
                numDays = 183;
                break;
            case "1 year":
                numDays = 365;
                break;
            case "All Time":
                numDays = item.getPriceHistoryDates().size();
                break;
            default:
                numDays = -1;
                break;
        }
        if (numDays > item.getPriceHistoryDates().size()){
            return -1;
        }
        else {
            return numDays;
        }
    }

    /**
     * Calculates the average price of an item within the recent specified time span. Returns -1 if the time period
     * input is invalid or if there is not enough info to calculate this.
     * @param timePeriod time period of the average to be calculated. Acceptable inputs include: 24 hours, 1 week,
     *                   30 days, 6 months, 1 year, and All Time
     * @return the item's calculated average over the recent specified time period or -1 if invalid
     */
    public double calculateAveragePrice(String timePeriod) {
        int priceDataSize = item.getPriceHistoryData().size();
        int numDays = convertValidTimePeriodToDaysHelper(timePeriod, item);
        //checking valid inputs
        if (numDays == -1){
            return -1;
        }

        int i = 1;
        double priceAverage = 0;

        // adds prices from most recent price to specified range
        while((i <= priceDataSize) && (i <= numDays)){
            priceAverage = priceAverage + item.getPriceHistoryData().get(priceDataSize - i);
            i = i + 1;
        }
        if (numDays == 0){
            return -1;
        }
        else{
            return Double.valueOf(formatter.format(priceAverage/numDays));
        }

    }

    /**
     * Calculates the lowest price of an item within the recent specified time span. Returns -1 for invalid input
     * @param timePeriod time period range of the lowest price to be calculated. Acceptable inputs include: 24 hours,
     *                   1 week, 30 days, 6 months, 1 year, and All Time
     * @return the item's lowest price over the recent specified time period or -1 for invalid input
     */
    public double calculateLowestPrice(String timePeriod) {
        int priceDataSize = item.getPriceHistoryData().size();
        int numDays = convertValidTimePeriodToDaysHelper(timePeriod, item);
        //checking valid inputs
        if (numDays == -1){
            return -1;
        }

        int i = 1;
        double minSoFar = item.getItemPrice();
        while((i <= priceDataSize) && (i <= numDays)){
            minSoFar = Math.min(minSoFar, item.getPriceHistoryData().get(priceDataSize - i));
            i = i + 1;
        }
        return Double.valueOf(formatter.format(minSoFar));
    }

    /**
     * Calculates the highest price of an item within the recent specified time span. Returns -1 for invalid input
     * @param timePeriod time period range of the highest price to be calculated. Acceptable inputs include: 24 hours,
     *                   1 week, 30 days, 6 months, 1 year, and All Time
     * @return the item's highest price over the recent specified time period or -1 for invalid input
     */
    public double calculateHighestPrice(String timePeriod) {
        int priceDataSize = item.getPriceHistoryData().size();
        int numDays = convertValidTimePeriodToDaysHelper(timePeriod, item);
        //checking valid inputs
        if (numDays == -1){
            return -1;
        }

        int i = 1;
        double maxSoFar = item.getItemPrice();
        while((i <= priceDataSize) && (i <= numDays)){
            maxSoFar = Math.max(maxSoFar, item.getPriceHistoryData().get(priceDataSize - i));
            i = i + 1;
        }
        return Double.valueOf(formatter.format(maxSoFar));
    }

    /**
     * Calculates the difference in the current price in proportion to the desired price (ex. $20 item with $10 desired
     * price should return 200) or -1 if the desired price is invalid input (0)
     * @return percentage of current price compared to desired price or -1 for invalid calculations
     */
    public double calculatePercentChangeFromDesiredPrice(){
        if (item.getItemDesiredPrice() == 0){
            return -1;
        }
        else{
            return Double.valueOf(formatter.format((item.getItemPrice()/ item.getItemDesiredPrice())*100));
        }

    }

    /**
     * Calculates the difference in the current price in proportion to the original price from when the item was added
     * (ex. $20 item with $10 original price should return 200) or -1 if the original price is $0
     * @return percentage of current price compared to original price or -1 for invalid calculations
     */
    public double calculatePercentChangeFromOriginalPrice(){
        if (item.getPriceHistoryData().get(0) == 0){
            return -1;
        }
        else {
            return Double.valueOf(formatter.format((item.getItemPrice()/ item.getPriceHistoryData().get(0))*100));
        }
    }

    /**
     * Compares current price to the average price over a specified time period (in percentage form)
     * @param timePeriod time period range of the average price to compare to. Acceptable inputs include: 24 hours,
     *                   1 week, 0 days, 6 months, 1 year, and All Time
     * @return percentage of current price compared to item's average price over the recent specified
     * time period or -1 for invalid input
     */
    public double compareToAveragePrice(String timePeriod){
        int numDays = convertValidTimePeriodToDaysHelper(timePeriod, item);
        //checking valid inputs
        if (numDays == -1){
            return -1;
        }
        else if (calculateAveragePrice(timePeriod) == 0){
            return -1;
        }
        else {
            return Double.valueOf(formatter.format((item.getItemPrice() / calculateAveragePrice(timePeriod))*100));
        }
    }

    /**
     * Compares current price to the lowest price over a specified time period (in percentage form)
     * @param timePeriod time period range of the lowest price to compare to. Acceptable inputs include: 24 hours,
     *                   1 week, 0 days, 6 months, 1 year, and All Time
     * @return percentage of current price compared to item's lowest price over the recent specified
     * time period or -1 for invalid input
     */
    public double compareToLowestPrice(String timePeriod){
        int numDays = convertValidTimePeriodToDaysHelper(timePeriod, item);
        //checking valid inputs
        if (numDays == -1){
            return -1;
        }
        else if(calculateLowestPrice(timePeriod) == 0){
            return -1;
        }
        else {
            return Double.valueOf(formatter.format((item.getItemPrice() / calculateLowestPrice(timePeriod))*100));
        }
    }

    /**
     * Compares current price to the highest price over a specified time period (in percentage form)
     * @param timePeriod time period range of the lowest price to compare to. Acceptable inputs include: 24 hours,
     *                   1 week, 0 days, 6 months, 1 year, and All Time
     * @return percentage of current price compared to item's lowest price over the recent specified
     * time period or -1 for invalid input
     */
    public double compareToHighestPrice(String timePeriod){
        int numDays = convertValidTimePeriodToDaysHelper(timePeriod, item);
        //checking valid inputs
        if (numDays == -1){
            return -1;
        }
        else if (calculateHighestPrice(timePeriod) == 0){
            return -1;
        }
        else {
            return Double.valueOf(formatter.format((item.getItemPrice() / calculateHighestPrice(timePeriod))*100));
        }
    }


}
