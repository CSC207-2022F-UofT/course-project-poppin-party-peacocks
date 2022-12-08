//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package UseCases.PriceHistory;

import Controller.Scheduler;
import Entities.Product;
import ExternalInterface.ItemUpdateChecker;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimerTask;

/**
 * The Use Case layer for the price historu feature of an item.
 * item: the corresponding item (product interface layer) that the price history will be based off
 * @author Chin Chin
 */
public class PriceHistoryUseCase {
    // item: the corresponding item that the price history will be based off of
    public Product item;
    DecimalFormat formatter = new DecimalFormat("#.##");

    /**
     * initializer for PriceHistoryUseCase
     * @param item the item that the price history will be based off of
     */
    public PriceHistoryUseCase(final Product item) {
        this.item = item;
        TimerTask t = new TimerTask() {
            public void run() {
                try {
                    PriceHistoryUseCase.this.updatePriceHistoryData(item);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Scheduler scheduler = new Scheduler(t, 86400000);
    }

    /**
     * Adds the daily updated price of an item to its priceHistoryData
     *
     * @param item the item whose priceHistoryData will be updated
     */
    public void updatePriceHistoryData(Product item) throws IOException {
        ArrayList<Double> updatedPriceHistoryData = item.getPriceHistoryData();
        ArrayList<Date> updatedPriceHistoryDates = item.getPriceHistoryDates();
        ItemUpdateChecker updater = new ItemUpdateChecker();
        updater.updatePriceCheck(item);
        updatedPriceHistoryData.add(item.getProductPrice());
        updatedPriceHistoryDates.add(new Date());
        item.setPriceHistoryData(updatedPriceHistoryData);
        item.setPriceHistoryDates(updatedPriceHistoryDates);
    }

    /**
     * Helper method for turning time period inputs to number of days. Returns -1 for invalid input.
     * @param timePeriod the specified time period
     * @return the approximate number of days in the specified time period or -1 for invalid inputs
     */
    public int convertValidTimePeriodToDaysHelper(String timePeriod) {
        int numDays;
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
                numDays = this.item.getPriceHistoryDates().size();
                break;
            default:
                numDays = -1;
                break;
        }

        return numDays > this.item.getPriceHistoryDates().size() ? -1 : numDays;
    }

    /**
     * Calculates the average price of an item within the recent specified time span. Returns -1 if the time period
     * input is invalid or if there is not enough info to calculate this.
     * @param timePeriod time period of the average to be calculated. Acceptable inputs include: 24 hours, 1 week,
     *                   30 days, 6 months, 1 year, and All Time
     * @return the item's calculated average over the recent specified time period or -1 if invalid
     */
    public double calculateAveragePrice(String timePeriod) {
        int priceDataSize = this.item.getPriceHistoryData().size();
        int numDays = this.convertValidTimePeriodToDaysHelper(timePeriod);
        //checking valid inputs
        if (numDays == -1) {
            return -1.0;
        } else {
            int i = 1;

            double priceAverage;
            for(priceAverage = 0.0; i <= priceDataSize && i <= numDays; ++i) {
                priceAverage += this.item.getPriceHistoryData().get(priceDataSize - i);
            }

            return numDays == 0 ? -1.0 : Double.parseDouble(this.formatter.format(priceAverage / (double)numDays));
        }
    }

    /**
     * Calculates the lowest price of an item within the recent specified time span. Returns -1 for invalid input
     * @param timePeriod time period range of the lowest price to be calculated. Acceptable inputs include: 24 hours,
     *                   1 week, 30 days, 6 months, 1 year, and All Time
     * @return the item's lowest price over the recent specified time period or -1 for invalid input
     */
    public double calculateLowestPrice(String timePeriod) {
        int priceDataSize = this.item.getPriceHistoryData().size();
        int numDays = this.convertValidTimePeriodToDaysHelper(timePeriod);
        if (numDays == -1) {
            return -1.0;
        } else {
            int i = 1;

            double minSoFar;
            for(minSoFar = this.item.getProductPrice(); i <= priceDataSize && i <= numDays; ++i) {
                minSoFar = Math.min(minSoFar, this.item.getPriceHistoryData().get(priceDataSize - i));
            }

            return Double.parseDouble(this.formatter.format(minSoFar));
        }
    }

    /**
     * Calculates the highest price of an item within the recent specified time span. Returns -1 for invalid input
     * @param timePeriod time period range of the highest price to be calculated. Acceptable inputs include: 24 hours,
     *                   1 week, 30 days, 6 months, 1 year, and All Time
     * @return the item's highest price over the recent specified time period or -1 for invalid input
     */
    public double calculateHighestPrice(String timePeriod) {
        int priceDataSize = this.item.getPriceHistoryData().size();
        int numDays = this.convertValidTimePeriodToDaysHelper(timePeriod);
        if (numDays == -1) {
            return -1.0;
        } else {
            int i = 1;

            double maxSoFar;
            for(maxSoFar = this.item.getProductPrice(); i <= priceDataSize && i <= numDays; ++i) {
                maxSoFar = Math.max(maxSoFar, this.item.getPriceHistoryData().get(priceDataSize - i));
            }

            return Double.parseDouble(this.formatter.format(maxSoFar));
        }
    }

    /**
     * Calculates the difference in the current price in proportion to the desired price (ex. $20 item with $10 desired
     * price should return 200) or -1 if the desired price is invalid input (0)
     * @return percentage of current price compared to desired price or -1 for invalid calculations
     */
    public double calculatePercentChangeFromDesiredPrice() {
        return this.item.getProductDesiredPrice() == 0.0 ? -1.0 : Double.parseDouble(this.formatter.format(this.item.getProductPrice() / this.item.getProductDesiredPrice() * 100.0));
    }

    /**
     * Calculates the difference in the current price in proportion to the original price from when the item was added
     * (ex. $20 item with $10 original price should return 200) or -1 if the original price is $0
     * @return percentage of current price compared to original price or -1 for invalid calculations
     */
    public double calculatePercentChangeFromOriginalPrice() {
        return this.item.getPriceHistoryData().get(0) == 0.0 ? -1.0 : Double.parseDouble(this.formatter.format(this.item.getProductPrice() / this.item.getPriceHistoryData().get(0) * 100.0));
    }

    /**
     * Compares current price to the average price over a specified time period (in percentage form)
     * @param timePeriod time period range of the average price to compare to. Acceptable inputs include: 24 hours,
     *                   1 week, 0 days, 6 months, 1 year, and All Time
     * @return percentage of current price compared to item's average price over the recent specified
     * time period or -1 for invalid input
     */
    public double compareToAveragePrice(String timePeriod) {
        int numDays = this.convertValidTimePeriodToDaysHelper(timePeriod);
        if (numDays == -1) {
            return -1.0;
        } else {
            return this.calculateAveragePrice(timePeriod) == 0.0 ? -1.0 : Double.parseDouble(this.formatter.format(this.item.getProductPrice() / this.calculateAveragePrice(timePeriod) * 100.0));
        }
    }

    /**
     * Compares current price to the lowest price over a specified time period (in percentage form)
     * @param timePeriod time period range of the lowest price to compare to. Acceptable inputs include: 24 hours,
     *                   1 week, 0 days, 6 months, 1 year, and All Time
     * @return percentage of current price compared to item's lowest price over the recent specified
     * time period or -1 for invalid input
     */
    public double compareToLowestPrice(String timePeriod) {
        int numDays = this.convertValidTimePeriodToDaysHelper(timePeriod);
        if (numDays == -1) {
            return -1.0;
        } else {
            return this.calculateLowestPrice(timePeriod) == 0.0 ? -1.0 : Double.parseDouble(this.formatter.format(this.item.getProductPrice() / this.calculateLowestPrice(timePeriod) * 100.0));
        }
    }

    /**
     * Compares current price to the highest price over a specified time period (in percentage form)
     * @param timePeriod time period range of the lowest price to compare to. Acceptable inputs include: 24 hours,
     *                   1 week, 0 days, 6 months, 1 year, and All Time
     * @return percentage of current price compared to item's lowest price over the recent specified
     * time period or -1 for invalid input
     */
    public double compareToHighestPrice(String timePeriod) {
        int numDays = this.convertValidTimePeriodToDaysHelper(timePeriod);
        if (numDays == -1) {
            return -1.0;
        } else {
            return this.calculateHighestPrice(timePeriod) == 0.0 ? -1.0 : Double.parseDouble(this.formatter.format(this.item.getProductPrice() / this.calculateHighestPrice(timePeriod) * 100.0));
        }
    }

    /**
     * Generates and saves jpeg of the price history graph for the item in this pricehistoryusecase
     * saves jpeg in the assets folder
     * @throws IOException ioexception
     */
    public void generatePriceChart() throws IOException {
        DefaultCategoryDataset chartDataSet = new DefaultCategoryDataset();
        ArrayList<Double> prices = this.item.getPriceHistoryData();
        ArrayList<Date> dates = this.item.getPriceHistoryDates();
        String datePattern = "MM-dd-yyyy";
        SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
        String series = "Date";

        for(int i = 0; i < prices.size(); ++i) {
            chartDataSet.addValue(prices.get(i), series, dateFormatter.format(dates.get(i)));
        }

        JFreeChart priceChart = ChartFactory.createLineChart("Price History", "Date", "Price", chartDataSet);

        ChartUtils.saveChartAsJPEG(new File("src/main/java/Assets/price_history.jpeg"), priceChart, 450, 400);
    }
}
