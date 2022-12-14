package ExternalInterface;

import Entities.Product;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

public class ItemUpdateChecker {
    /**
     * format for displaying prices rounded to 2 decimal points.
     */
    private static final DecimalFormat df = new DecimalFormat("0.00");

    /**
     * Using Jsoup library to fetch updated price of specific item on Amazon.
     *
     * @param item takes product item and checks for price change, if so, price will be updated respective to the object
     */
    public void updatePriceCheck(Product item) throws IOException {
        // This line specifies window type and layout of amazon page based on  Window Version and browser for webscraping
        Document doc = Jsoup.connect(item.getProductURL()).timeout(10000).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36").get();
        Element price = doc.select(".a-offscreen").first();
        assert price != null;
        double sellingPrice = Double.parseDouble(price.text().substring(1));

        if (!item.getProductCurrency().equals("CAD")){
            sellingPrice = Double.parseDouble(df.format(sellingPrice * (1/1.34)));
        }

        item.setPriceChange(item.getProductPrice() - sellingPrice);
        item.setProductPrice(sellingPrice);
        ArrayList<Double> priceList = item.getPriceHistoryData();
        ArrayList<Date> dateList = item.getPriceHistoryDates();
        priceList.add(sellingPrice);
        dateList.add(new Date());
        item.setPriceHistoryData(priceList);
        item.setPriceHistoryDates(dateList);
    }
}
