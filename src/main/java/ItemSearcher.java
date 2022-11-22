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

public class ItemSearcher {

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
    public ArrayList searchToList(String keyword, String marketplace) throws IOException, InterruptedException {

        String response = apiSearch(keyword, marketplace);
        response = cleanResponse(response);

        ArrayList<Item> itemList = new ArrayList<Item>();
        String[] pairs = response.split(" , ");

        ArrayList<String> titleList = new ArrayList<String>();
        ArrayList<String> priceList = new ArrayList<String>();
        ArrayList<String> urlList = new ArrayList<String>();
        ArrayList<String> reviewCountList = new ArrayList<String>();
        ArrayList<String> reviewStarList = new ArrayList<String>();
        ArrayList<String> imageUrlList = new ArrayList<String>();
        for (int i = 0; i < pairs.length; i++) {
            String pair = pairs[i];
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
            Item newItem = new Item(titleList.get(i), Double.parseDouble(priceList.get(i)), Double.parseDouble(priceList.get(i)), urlList.get(i), titleList.get(i), new String[]{keyword}, Integer.parseInt(reviewCountList.get(i).replace(" ", "")), Double.parseDouble(reviewStarList.get(i).replace(" ", "")), imageUrlList.get(i));
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

    private String itemLinkGenerator(String keywords) {
        return "https://www.amazon.ca/s?k=" + keywords.replace(" ", "+");
    }

    public ArrayList<Item> searchItemKeywords(String keywords) throws IOException, InterruptedException {
        String url = this.itemLinkGenerator(keywords);
        ArrayList<Item> itemList = new ArrayList<>();
        ArrayList<String> listNames = new ArrayList<>();
        ArrayList<Double> listPrices = new ArrayList<>();
        ArrayList<String> listUrls = new ArrayList<>();
        ArrayList<Double> listStars = new ArrayList<>();
        ArrayList<Integer> listCount = new ArrayList<>();
        ArrayList<String> listImgs = new ArrayList<>();
        try {
            // This line specifies window type and layout of amazon page based on  Window Version and browser for webscraping
            Document doc = Jsoup.connect(url).timeout(10000).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36").get();
//            Elements productNames = doc.select("div.s-widget-container.s-spacing-small.s-widget-container-height-small.celwidget").select("span.a-size-base-plus.a-color-base.a-text-normal");
//
//            Elements productPrices = doc.select("div.s-widget-container.s-spacing-small.s-widget-container-height-small.celwidget").select("span.a-offscreen");
//
//            Elements productImages = doc.select("span.rush-component").select("a.a-link-normal.s-no-outline").select("div.a-section.aok-relative.s-image-square-aspect").select("img");
//
//
            Elements productUrls = doc.select("h2.a-size-mini.a-spacing-none.a-color-base.s-line-clamp-4").select("a");
//
//            Elements productCounts = doc.select("a.a-link-normal.s-underline-text.s-underline-link-text.s-link-style").select("span.a-size-base.s-underline-text");
//
//            Elements productStars = doc.select("div.a-fixed-left-grid-col a-col-left").select("span");
//
//            for (Element item: productNames){
//                listNames.add(item.text());
//
//
//            }
//
//            for (Element item: productPrices){
//                listPrices.add(Double.parseDouble(item.text().replace(",","").substring(1)));
//            }

//            for (Element item: productImages){
//                listImgs.add(item.attr("src"));
//            }

            for (Element item : productUrls) {
                String newUrl = "https://www.amazon.ca" + item.attr("href");
                listUrls.add(newUrl);
            }

            for (int i = 0; i < 10; i++) {
                itemList.add(searchItemUrl(listUrls.get(i)));
            }

//            for (Item item: itemList){
//                System.out.println(item.getItemName());
//                System.out.println(item.getItemDescription());
//                System.out.println(item.getItemPrice());
//                System.out.println(item.getItemURL());
//                System.out.println(item.getReviewCount());
//                System.out.println(item.getReviewStars());
//                System.out.println(item.getItemImageURL());
//            }
            return itemList;

//            for (Element item: productCounts){
//                listCount.add(Integer.parseInt(item.text().replace(",","")));
//            }

//            System.out.println(listNames.size());
//            System.out.println(listPrices.size());
//            System.out.println(listUrls.size());
//            System.out.println(listCount.size());
//            System.out.println(listImgs.size());

        } catch (IOException e) {
            return new ArrayList<Item>();

        }


    }

    public Item searchItemUrl(String url) throws IOException {

        try {
            // This line specifies window type and layout of amazon page based on  Window Version and browser for webscraping
            Document doc = Jsoup.connect(url).timeout(10000).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36").get();
            Element htmlName = doc.select(".a-size-large.product-title-word-break").first();
            Element price = doc.select(".a-offscreen").first();
            Element htmlDescription = doc.select("ul.a-unordered-list.a-vertical.a-spacing-mini").select("span.a-list-item").first();
            Element htmlCountRating = doc.select("div.a-row.a-spacing-medium.averageStarRatingNumerical").select("span.a-size-base.a-color-secondary").first();
            Element htmlImgUrl = doc.select("ul.a-unordered-list.a-nostyle.a-horizontal.list.maintain-height").select("span.a-list-item span.a-declarative").select("span.a-declarative").select("div.imgTagWrapper").select("img").first();
            Element htmlStarRating = doc.select("div.a-fixed-left-grid-col.aok-align-center.a-col-right").select("div.a-row").select("span.a-size-base.a-nowrap").first();


            assert price != null;
            double sellingPrice = Double.parseDouble(price.text().substring(1));
            int countRating = Integer.parseInt(htmlCountRating.text().replace(",", "").split(" ")[0]);
            double starRating = Double.parseDouble(htmlStarRating.text().split(" ")[0]);
            assert htmlImgUrl != null;
            String imgUrl = htmlImgUrl.attr("src");
            assert htmlName != null;
            String name = htmlName.text();
            assert htmlDescription != null;
            String description = htmlDescription.text();
            return new Item(name, sellingPrice, sellingPrice, url, description, new String[]{}, countRating, starRating, imgUrl);


        } catch (IOException e) {
            return new Item("", 0, 0, "", "", new String[]{}, 0, 0, "");
        }


    }


}