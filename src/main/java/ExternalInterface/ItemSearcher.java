package ExternalInterface;

import Entities.Item;
import Entities.Product;
import UseCases.Currency.CurrencyUseCase;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Objects;

public class ItemSearcher {


    public ItemSearcher(){
    }

    /**
     * Returns generated search amazon link based on keyword
     *
     * @param keywords string keyword to search in Amazon
     */
    private String itemLinkGenerator(String keywords) {
        return "https://www.amazon.ca/s?k=" + keywords.replace(" ", "+");
    }

    /**
     * Returns Arraylist of Item objects based on search results of the specified keyword on AMazon
     *
     * @param keywords string keyword to search in Amazon interface
     */

    public ArrayList<Product> searchItemKeywords(String keywords) throws IOException, InterruptedException {
        String url = this.itemLinkGenerator(keywords);
        ArrayList<Product> itemList = new ArrayList<>();
        ArrayList<String> listUrls = new ArrayList<>();


            Document doc = Jsoup.connect(url).timeout(10000).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36").get();
            Elements productUrls = doc.select("h2.a-size-mini.a-spacing-none.a-color-base a");
            for (Element item : productUrls) {
                String newUrl = "https://www.amazon.ca" + item.attr("href");
                listUrls.add(newUrl);
            }
            int counter = 0;
            for (String itemUrl : listUrls) {
                if (counter == 10) {
                    break;
                }
                Product item = searchItemUrl(itemUrl, true);
                if (!Objects.equals(item.getProductName(), "") && item.getProductPrice() != 0) {
                    itemList.add(item);
                    counter += 1;
                }
            }
            return itemList;


    }

    /**
     * Searches for item based on given url. Returns Item object based on given Amazon Url
     *
     * @param url url of amazon item
     */
    public Product searchItemUrl(String url, boolean searchByKeyword) throws IOException {

            // This line specifies window type and layout of amazon page based on  Window Version and browser for webscraping
            Document doc = Jsoup.connect(url).timeout(10000).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36").get();
            Element htmlName = doc.select(".a-size-large.product-title-word-break").first();
            Element price = doc.select(".a-offscreen").first();
            Element htmlDescription = doc.select("div.a-row.feature").select("div.a-section.a-spacing-small").select("span").first();
            Element htmlCountRating = doc.select("div.a-row.a-spacing-medium.averageStarRatingNumerical").select("span.a-size-base.a-color-secondary").first();
            Element htmlImgUrl = doc.select("ul.a-unordered-list.a-nostyle.a-horizontal.list.maintain-height").select("span.a-list-item span.a-declarative").select("span.a-declarative").select("div.imgTagWrapper").select("img").first();
            Element htmlStarRating = doc.select("div.a-fixed-left-grid-col.aok-align-center.a-col-right").select("div.a-row").select("span.a-size-base.a-nowrap").first();

            if ((htmlName == null || price == null || htmlDescription == null || htmlCountRating == null || htmlImgUrl == null || htmlStarRating == null) && searchByKeyword) {
                return new Item("", 0, 0, "", "", 0, 0, "");
            }
            double sellingPrice = 0;
            String description = "";
            String name = "";
            String imgUrl = "";
            int countRating = 0;
            double starRating = 0;
            assert price != null;
            String sellingPriceStr = price.text().replace(",", "").substring(1);

            if (!sellingPriceStr.matches(".*[a-zA-Z]+.*")) {

                sellingPrice = Double.parseDouble(sellingPriceStr);

            }
            if (htmlCountRating != null) {
                countRating = Integer.parseInt(htmlCountRating.text().replace(",", "").split(" ")[0]);
            }
            if (htmlStarRating != null) {
                starRating = Double.parseDouble(htmlStarRating.text().split(" ")[0]);
            }
            if (htmlImgUrl != null) {
                imgUrl = htmlImgUrl.attr("src");
            }
            if (htmlName != null) {
                name = htmlName.text();
            }
            if (htmlDescription != null) {
                description = htmlDescription.text();
            }

            Product itemResult = new Item(name, sellingPrice, sellingPrice, url, description, countRating, starRating, imgUrl, "CAD");

            CurrencyUseCase currencyUseCase = new CurrencyUseCase();
            currencyUseCase.updateProductCurrency(itemResult);



            return itemResult;

    }
}
