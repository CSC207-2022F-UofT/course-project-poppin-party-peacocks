package ExternalInterface;

import Entities.Product;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Date;

public class ItemUpdateChecker {
    /**
     * Using Jsoup library to fetch updated price of specific item on Amazon.
     *
     * @param item   takes product item and checks for price change, if so, price will be updated respective to the object
     */


    public Double updatePriceCheck(Product item) throws IOException {
        try {
            // This line specifies window type and layout of amazon page based on  Window Version and browser for webscraping
            Document doc = Jsoup.connect(item.getProductURL()).timeout(10000).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36").get();
            Element price = doc.select(".a-offscreen").first();
            assert price != null;
            double sellingPrice = Double.parseDouble(price.text().substring(1));
            item.setPriceChange(item.getProductPrice() - sellingPrice);
            item.setProductPrice(sellingPrice);
            item.setDateLastUpdated(new Date());
        } catch (IOException e){
            e.printStackTrace();
        }
        return 0.0;
    }
}
