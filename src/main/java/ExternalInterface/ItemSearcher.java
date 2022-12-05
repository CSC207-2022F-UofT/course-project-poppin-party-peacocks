package ExternalInterface;

import Entities.Item;
import Entities.Product;
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

    private String userCurrency = "CAD";
    private double currencyChange = 1.36;
    public ItemSearcher(){
    }

    public ItemSearcher(String userCurrency){
        this.userCurrency = userCurrency;
    }

    /**
     * Calls Amazon Api search tool to return json string of search results of specified keyword and marketplace
     *
     * @param keywords    string keyword to search in Amazon
     * @param marketplace specified marketplace (ex: "CA" for Canada) to search in Amazon
     */
    private String apiSearch(String keywords, String marketplace) throws IOException, InterruptedException {
        String linkurl = keywordstext(keywords, marketplace);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(linkurl))
                .header("X-RapidAPI-Key", "9364e66fc1mshe8be4541ae0999ap180a9ejsn182bd6379d98")
                .header("X-RapidAPI-Host", "amazon-price1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return (response.body());
    }

    /**
     * Cleans Api return string
     *
     * @param response string keyword to search in Amazon
     */
    private String cleanResponse(String response) {
        String modifiedResponse = response.replace("[{", "");
        modifiedResponse = modifiedResponse.replace("}]", "");
        modifiedResponse = modifiedResponse.replace('"', ' ');
        modifiedResponse = modifiedResponse.replace(", ", ",");
        modifiedResponse = modifiedResponse.replace(": ", ":");
        modifiedResponse = modifiedResponse.replace("{", "");
        modifiedResponse = modifiedResponse.replace("}", "");
        return modifiedResponse;
    }

    /**
     * Returns Arraylist of Item objects based on search results of the specified keyword on AMazon
     *
     * @param keyword     string keyword to search in Amazon
     * @param marketplace specified marketplace (ex: "CA" for Canada) to search in Amazon
     */
    public ArrayList<Product> searchToList(String keyword, String marketplace) throws IOException, InterruptedException {
        String response = apiSearch(keyword, marketplace);
        response = cleanResponse(response);
        ArrayList<Product> itemList = new ArrayList<Product>();
        String[] pairs = response.split(" , ");
        ArrayList<String> titleList = new ArrayList<String>();
        ArrayList<String> priceList = new ArrayList<String>();
        ArrayList<String> urlList = new ArrayList<String>();
        ArrayList<String> reviewCountList = new ArrayList<String>();
        ArrayList<String> reviewStarList = new ArrayList<String>();
        ArrayList<String> imageUrlList = new ArrayList<String>();
        for (String pair : pairs) {
            String[] keyValue = pair.split(" :");
            if (keyValue[0].contains("title") && !keyValue[0].contains("subtitle")) {
                titleList.add(keyValue[1]);
            }
            if (keyValue[0].contains("price")) {
                priceList.add(keyValue[1].replace("$", ""));
            }
            if (keyValue[0].contains("detailPageURL")) {
                urlList.add(keyValue[1]);
            }
            if (keyValue[0].contains("totalReviews")) {
                reviewCountList.add(keyValue[1]);
            }
            if (keyValue[0].contains("rating")) {
                reviewStarList.add(keyValue[1]);
            }
            if (keyValue[0].contains("imageUrl")) {
                imageUrlList.add(keyValue[1]);
            }
        }

        for (int i = 0; i < titleList.size(); i++) {
            Product newItem = new Item(titleList.get(i), Double.parseDouble(priceList.get(i)), Double.parseDouble(priceList.get(i)), urlList.get(i), titleList.get(i), new String[]{keyword}, Integer.parseInt(reviewCountList.get(i).replace(" ", "")), Double.parseDouble(reviewStarList.get(i).replace(" ", "")), imageUrlList.get(i));
            itemList.add(newItem);
        }
        return itemList;
    }

    /**
     * Returns custom url link with respective keyword search and marketplace
     *
     * @param keywords    string keyword to search in Amazon
     * @param marketplace specified marketplace (ex: "CA" for Canada) to search in Amazon
     */
    private String keywordstext(String keywords, String marketplace) {
        return "https://amazon-price1.p.rapidapi.com/search?keywords=" + keywords.replace(" ", "%20") + "&marketplace=" + marketplace;
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

        try {
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
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    /**
     * Searches for item based on given url. Returns Item object based on given Amazon Url
     *
     * @param url url of amazon item
     */
    public Product searchItemUrl(String url, boolean searchByKeyword) throws IOException {
        try {
            // This line specifies window type and layout of amazon page based on  Window Version and browser for webscraping
            Document doc = Jsoup.connect(url).timeout(10000).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36").get();
            Element htmlName = doc.select(".a-size-large.product-title-word-break").first();
            Element price = doc.select(".a-offscreen").first();
            Element htmlDescription = doc.select("div.a-row.feature").select("div.a-section.a-spacing-small").select("span").first();
            Element htmlCountRating = doc.select("div.a-row.a-spacing-medium.averageStarRatingNumerical").select("span.a-size-base.a-color-secondary").first();
            Element htmlImgUrl = doc.select("ul.a-unordered-list.a-nostyle.a-horizontal.list.maintain-height").select("span.a-list-item span.a-declarative").select("span.a-declarative").select("div.imgTagWrapper").select("img").first();
            Element htmlStarRating = doc.select("div.a-fixed-left-grid-col.aok-align-center.a-col-right").select("div.a-row").select("span.a-size-base.a-nowrap").first();

            if ((htmlName == null || price == null || htmlDescription == null || htmlCountRating == null || htmlImgUrl == null || htmlStarRating == null) && searchByKeyword) {
                return new Item("", 0, 0, "", "", new String[]{}, 0, 0, "");
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

                if (!userCurrency.equals("CAD")){
                    sellingPrice *= currencyChange;
                }
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
            return new Item(name, sellingPrice, sellingPrice, url, description, new String[]{}, countRating, starRating, imgUrl);
        } catch (IOException e) {
            return new Item("", 0, 0, "", "", new String[]{}, 0, 0, "");
        }
    }
}
