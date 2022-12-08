
package ExternalInterface;

import Entities.Product;
import UseCases.PriceHistory.PriceHistoryUseCase;

import java.io.IOException;

/**
 * Interface layer for the Price History feature.
 * ph: the corresponding price history use case
 * @author Chin Chin
 */
public class PriceHistoryInterface {
    /**
     * ph: the corresponding price history use case
     */
    PriceHistoryUseCase ph;

    /**
     * initializing the PriceHistoryInterface, corresponding to item
     * @param item the item that the PriceHistory corresponds to
     */
    public PriceHistoryInterface(Product item) {
        // ph: Price History Use Case layer for the corresponding product
        this.ph = new PriceHistoryUseCase(item);
    }

    /**
     * Parses the price comparison to the original price
     * @return price comparison to the original price
     */
    public String parseOriginalPrice() {
        return String.valueOf(this.ph.calculatePercentChangeFromOriginalPrice());
    }

    /**
     * Parses the price comparison to the desired price
     * @return price comparison to the desired price
     */
    public String parseDesiredPrice() {
        return String.valueOf(this.ph.calculatePercentChangeFromDesiredPrice());
    }

    /**
     * Parses the price comparison to the lowest price, according to timePeriod
     * @param timePeriod the time period specified to compare the lowest price in
     * @return price comparison to the lowest price in the time period or "-" if invalid
     */
    public String parseLowestPrice(String timePeriod) {
        Double num = this.ph.compareToLowestPrice(timePeriod);
        return num == -1.0 ? "-" : String.valueOf(num);
    }

    /**
     * Parses the price comparison to the highest price, according to timePeriod
     * @param timePeriod the time period specified to compare the highest price in
     * @return price comparison to the highest price in the time period or "-" if invalid
     */
    public String parseHighestPrice(String timePeriod) {
        Double num = this.ph.compareToHighestPrice(timePeriod);
        return num == -1.0 ? "-" : String.valueOf(num);
    }

    /**
     * Parses the price comparison to the average price, according to timePeriod
     * @param timePeriod the time period specified to compare the average price in
     * @return price comparison to the average price in the time period or "-" if invalid
     */
    public String parseAveragePrice(String timePeriod) {
        Double num = this.ph.compareToAveragePrice(timePeriod);
        return num == -1.0 ? "-" : String.valueOf(num);
    }

    /**
     * Generates a price history chart
     * @throws IOException ioexception
     */
    public void createPriceHistoryChart() throws IOException {
        this.ph.generatePriceChart();
    }

}
