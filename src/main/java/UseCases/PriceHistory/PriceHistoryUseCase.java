//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package UseCases.PriceHistory;

import Controller.Scheduler;
import Entities.Item;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimerTask;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class PriceHistoryUseCase {
    public Item item;
    private Scheduler scheduler;
    DecimalFormat formatter = new DecimalFormat("#.##");

    public PriceHistoryUseCase(final Item item) {
        this.item = item;
        TimerTask t = new TimerTask() {
            public void run() {
                PriceHistoryUseCase.this.updatePriceHistoryData(item);
            }
        };
        this.scheduler = new Scheduler(t, 86400000);
    }

    public void updatePriceHistoryData(Item item) {
        ArrayList<Double> updatedPriceHistoryData = item.getPriceHistoryData();
        ArrayList<Date> updatedPriceHistoryDates = item.getPriceHistoryDates();
        updatedPriceHistoryData.add(item.getProductPrice());
        updatedPriceHistoryDates.add(new Date());
        item.setPriceHistoryData(updatedPriceHistoryData);
        item.setPriceHistoryDates(updatedPriceHistoryDates);
    }

    public int convertValidTimePeriodToDaysHelper(String timePeriod) {
        int numDays;
        if (timePeriod.equals("24 hours")) {
            numDays = 1;
        } else if (timePeriod.equals("1 week")) {
            numDays = 7;
        } else if (timePeriod.equals("30 days")) {
            numDays = 30;
        } else if (timePeriod.equals("6 months")) {
            numDays = 183;
        } else if (timePeriod.equals("1 year")) {
            numDays = 365;
        } else if (timePeriod.equals("All Time")) {
            numDays = this.item.getPriceHistoryDates().size();
        } else {
            numDays = -1;
        }

        return numDays > this.item.getPriceHistoryDates().size() ? -1 : numDays;
    }

    public double calculateAveragePrice(String timePeriod) {
        int priceDataSize = this.item.getPriceHistoryData().size();
        int numDays = this.convertValidTimePeriodToDaysHelper(timePeriod);
        if (numDays == -1) {
            return -1.0;
        } else {
            int i = 1;

            double priceAverage;
            for(priceAverage = 0.0; i <= priceDataSize && i <= numDays; ++i) {
                priceAverage += (Double)this.item.getPriceHistoryData().get(priceDataSize - i);
            }

            return numDays == 0 ? -1.0 : Double.valueOf(this.formatter.format(priceAverage / (double)numDays));
        }
    }

    public double calculateLowestPrice(String timePeriod) {
        int priceDataSize = this.item.getPriceHistoryData().size();
        int numDays = this.convertValidTimePeriodToDaysHelper(timePeriod);
        if (numDays == -1) {
            return -1.0;
        } else {
            int i = 1;

            double minSoFar;
            for(minSoFar = this.item.getProductPrice(); i <= priceDataSize && i <= numDays; ++i) {
                minSoFar = Math.min(minSoFar, (Double)this.item.getPriceHistoryData().get(priceDataSize - i));
            }

            return Double.valueOf(this.formatter.format(minSoFar));
        }
    }

    public double calculateHighestPrice(String timePeriod) {
        int priceDataSize = this.item.getPriceHistoryData().size();
        int numDays = this.convertValidTimePeriodToDaysHelper(timePeriod);
        if (numDays == -1) {
            return -1.0;
        } else {
            int i = 1;

            double maxSoFar;
            for(maxSoFar = this.item.getProductPrice(); i <= priceDataSize && i <= numDays; ++i) {
                maxSoFar = Math.max(maxSoFar, (Double)this.item.getPriceHistoryData().get(priceDataSize - i));
            }

            return Double.valueOf(this.formatter.format(maxSoFar));
        }
    }

    public double calculatePercentChangeFromDesiredPrice() {
        return this.item.getProductDesiredPrice() == 0.0 ? -1.0 : Double.valueOf(this.formatter.format(this.item.getProductPrice() / this.item.getProductDesiredPrice() * 100.0));
    }

    public double calculatePercentChangeFromOriginalPrice() {
        return (Double)this.item.getPriceHistoryData().get(0) == 0.0 ? -1.0 : Double.valueOf(this.formatter.format(this.item.getProductPrice() / (Double)this.item.getPriceHistoryData().get(0) * 100.0));
    }

    public double compareToAveragePrice(String timePeriod) {
        int numDays = this.convertValidTimePeriodToDaysHelper(timePeriod);
        if (numDays == -1) {
            return -1.0;
        } else {
            return this.calculateAveragePrice(timePeriod) == 0.0 ? -1.0 : Double.valueOf(this.formatter.format(this.item.getProductPrice() / this.calculateAveragePrice(timePeriod) * 100.0));
        }
    }

    public double compareToLowestPrice(String timePeriod) {
        int numDays = this.convertValidTimePeriodToDaysHelper(timePeriod);
        if (numDays == -1) {
            return -1.0;
        } else {
            return this.calculateLowestPrice(timePeriod) == 0.0 ? -1.0 : Double.valueOf(this.formatter.format(this.item.getProductPrice() / this.calculateLowestPrice(timePeriod) * 100.0));
        }
    }

    public double compareToHighestPrice(String timePeriod) {
        int numDays = this.convertValidTimePeriodToDaysHelper(timePeriod);
        if (numDays == -1) {
            return -1.0;
        } else {
            return this.calculateHighestPrice(timePeriod) == 0.0 ? -1.0 : Double.valueOf(this.formatter.format(this.item.getProductPrice() / this.calculateHighestPrice(timePeriod) * 100.0));
        }
    }

    public void generatePriceChart() throws IOException {
        DefaultCategoryDataset chartDataSet = new DefaultCategoryDataset();
        ArrayList<Double> prices = this.item.getPriceHistoryData();
        ArrayList<Date> dates = this.item.getPriceHistoryDates();
        String datePattern = "MM-dd-yyyy";
        SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
        String series = "Date";

        for(int i = 0; i < prices.size(); ++i) {
            chartDataSet.addValue((Number)prices.get(i), series, dateFormatter.format((Date)dates.get(i)));
        }

        JFreeChart priceChart = ChartFactory.createLineChart("Price History", "Date", "Price", chartDataSet);

        ChartUtils.saveChartAsJPEG(new File("src/main/java/Assets/price_history.jpeg"), priceChart, 450, 400);
    }
}
