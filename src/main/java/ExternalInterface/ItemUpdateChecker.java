package ExternalInterface;

import DataBase.DataBaseController;
import Entities.Product;
import Entities.User;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;

public class ItemUpdateChecker {
    /**
     * Using Jsoup library to fetch updated price of specific item on Amazon.
     *
     * @param item takes product item and checks for price change, if so, price will be updated respective to the object
     */
    private static final DecimalFormat df = new DecimalFormat("0.00");


    public void updatePriceCheck(Product item) throws IOException {
        // This line specifies window type and layout of amazon page based on  Window Version and browser for webscraping
        Document doc = Jsoup.connect(item.getProductURL()).timeout(10000).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36").get();
        Element price = doc.select(".a-offscreen").first();
        assert price != null;
        double sellingPrice = Double.parseDouble(price.text().substring(1));

        DataBaseController dataBaseController = new DataBaseController();
        User currUser = dataBaseController.getCurrentUser();

        if (!currUser.getCurrency().equals("CAD")){
            sellingPrice = Double.parseDouble(df.format(sellingPrice * 0.76));
        }

        item.setPriceChange(item.getProductPrice() - sellingPrice);
        item.setProductPrice(sellingPrice);
        item.setDateLastUpdated(new Date());
    }
}
