
package ExternalInterface;

import Entities.Item;
import Entities.Product;
import UseCases.PriceHistory.PriceHistoryUseCase;
import java.io.IOException;

public class PriceHistoryInterface {
    PriceHistoryUseCase ph;

    public PriceHistoryInterface(Product item) {
        Item pr = (Item)item;
        PriceHistoryUseCase ph = new PriceHistoryUseCase(pr);
        this.ph = ph;
    }

    public String parseOriginalPrice() {
        return String.valueOf(this.ph.calculatePercentChangeFromOriginalPrice());
    }

    public String parseDesiredPrice() {
        return String.valueOf(this.ph.calculatePercentChangeFromDesiredPrice());
    }

    public String parseLowestPrice(String timePeriod) {
        Double num = this.ph.compareToLowestPrice(timePeriod);
        return num == -1.0 ? "-" : String.valueOf(num);
    }

    public String parseHighestPrice(String timePeriod) {
        Double num = this.ph.compareToHighestPrice(timePeriod);
        return num == -1.0 ? "-" : String.valueOf(num);
    }

    public String parseAveragePrice(String timePeriod) {
        Double num = this.ph.compareToAveragePrice(timePeriod);
        return num == -1.0 ? "-" : String.valueOf(num);
    }

    public void createPriceHistoryChart() throws IOException {
        this.ph.generatePriceChart();
    }
}
