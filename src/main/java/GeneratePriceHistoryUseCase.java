import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class GeneratePriceHistoryUseCase {
    public Item item;

    /**
     * Adds the daily updated price of an item to its priceHistoryData
     *
     * @param item the item whose priceHistoryData will be updated
     */
    public void updatePriceHistoryData(Item item) {
        ArrayList<Double> updatedPriceHistoryData = item.getPriceHistoryData();
        updatedPriceHistoryData.add(item.getItemPrice());
        item.setPriceHistoryData(updatedPriceHistoryData);
    }

    /**
     * updates priceHistoryData every 24 hours
     */
    public class Scheduler {
        public void main(String[] args) {
            Timer timer = new Timer();
            TimerTask t = new TimerTask() {
                @Override
                public void run() {
                    updatePriceHistoryData(item);
                }
            };
            timer.schedule(t, 0l, 1000 * 60 * 60 * 24);
        }
    }

    /**
     * Creates and returns an array of all the dates ranging from the item's date-added to the date of the last
     * updatePrice call, in yyyy-MM-dd format.
     *
     * @return the array of all dates since the date the item was added
     * @throws ParseException
     */
    public String[] formatPriceHistoryXAxisForGraphing() throws ParseException {
        ArrayList<Double> priceData = item.getPriceHistoryData();
        String[] dates = new String[priceData.size()];

        // formatting the date added
        Date firstDate = item.getItemDateAdded();
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String firstDateString = dateFormatter.format(firstDate);

        // adding every date from the date added-date of the last price update call to return array of dates
        Calendar c = Calendar.getInstance();
        c.setTime(dateFormatter.parse(firstDateString));
        for (int i = 0; i < dates.length; i++) {
            c.add(Calendar.DATE, i);
            dates[i] = dateFormatter.format(c.getTime());
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

    private int convertValidTimePeriodToDaysHelper(String timePeriod, Item item){
        int numDays = 0;
        if(timePeriod.equals("24 hours")){
            numDays = 1;
        }
        else if (timePeriod.equals("1 week")) {
            numDays = 7;
        }
        else if (timePeriod.equals("30 days")) {
            numDays = 30;
        }
        else if (timePeriod.equals("6 months")) {
            numDays = 365/2;
        }
        else if (timePeriod.equals("1 year")) {
            numDays = 365;
        }
        else if (timePeriod.equals("All Time")) {
            numDays = item.getPriceHistoryData().size();
        }
        else{
            numDays = -1;
        }
        return numDays;
    }

    /**
     * Calculates the average price of an item within the recent specified time span. Returns -1 if the time period
     * input is invalid.
     * @param timePeriod time period of the average to be calculated. Acceptable inputs include: 24 hours, 1 week,
     *                   30 days, 6 months, 1 year, and All Time
     * @return the item's calculated average over the recent specified time period or -1 if the input time period is
     * invalid
     */
    public double calculateAveragePrice(String timePeriod) {
        int priceDataSize = item.getPriceHistoryData().size();
        int numDays = convertValidTimePeriodToDaysHelper(timePeriod, item);
        //checking valid inputs
        if (numDays == -1){
            return -1;
        }

        int i = 0;
        double priceAverage = 0;

        // adds prices from most recent price to specified range
        // if not enough prices to meet specified range, will just add prices of all available prices
        while((i <= priceDataSize) && (i <= numDays)){
            priceAverage = priceAverage + item.getPriceHistoryData().get(priceDataSize - i);
            i = i + 1;
        }
        return priceAverage/numDays;
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

        int i = 0;
        double minSoFar = item.getItemPrice();
        while((i <= priceDataSize) && (i <= numDays)){
            minSoFar = Math.min(minSoFar, item.getPriceHistoryData().get(priceDataSize - i));
            i = i + 1;
        }
        return minSoFar;

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

        int i = 0;
        double maxSoFar = item.getItemPrice();
        while((i <= priceDataSize) && (i <= numDays)){
            maxSoFar = Math.max(maxSoFar, item.getPriceHistoryData().get(priceDataSize - i));
            i = i + 1;
        }
        return maxSoFar;
    }

    /**
     * Calculates the difference in the current price in proportion to the desired price (ex. $20 item with $10 desired
     * price should return 200)
     * @return percentage of current price compared to desired price
     */
    public double calculatePercentChangeFromDesiredPrice(){
        return (item.getItemPrice()/ item.getItemDesiredPrice()) *100;
    }

    /**
     * Calculates the difference in the current price in proportion to the original price from when the item was added
     * (ex. $20 item with $10 original price should return 200)
     * @return percentage of current price compared to original price
     */
    public double calculatePercentChangeFromOriginalPrice(){
        return (item.getItemPrice()/ item.getPriceHistoryData().get(0)) *100;
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
        return (item.getItemPrice()/ calculateAveragePrice(timePeriod)) *100;
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
        return (item.getItemPrice()/ calculateLowestPrice(timePeriod)) *100;
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
        return (item.getItemPrice()/ calculateHighestPrice(timePeriod)) *100;
    }


}
