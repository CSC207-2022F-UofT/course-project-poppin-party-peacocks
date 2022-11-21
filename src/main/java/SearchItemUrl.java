import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.*;


public class SearchItemUrl {

    public Item searchItem(String url) throws IOException{

        try {
            // This line specifies window type and layout of amazon page based on  Window Version and browser for webscraping
            Document doc = Jsoup.connect(url).timeout(10000).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36").get();
            Element htmlName = doc.select(".a-size-large.product-title-word-break").first();
            Element price = doc.select(".a-offscreen").first();
            Element htmlDescription = doc.select("ul.a-unordered-list.a-vertical.a-spacing-mini").select("span.a-list-item").first();
            Element htmlCountRating = doc.select("div.a-row.a-spacing-medium.averageStarRatingNumerical").select("span.a-size-base.a-color-secondary").first();
            Element htmlImgUrl = doc.select("ul.a-unordered-list.a-nostyle.a-horizontal.list.maintain-height").select("span.a-list-item span.a-declarative").select("span.a-declarative").select("div.imgTagWrapper").select("img").first();
            Element htmlStarRating = doc.select("span.a-size-base.a-nowrap").select("span.a-size-medium.a-color-base").first();

            assert price != null;
            double sellingPrice = Double.parseDouble(price.text().substring(1));
            int countRating = Integer.parseInt(htmlCountRating.text().split(" ")[0]);
            double starRating = Double.parseDouble(htmlStarRating.text().split(" ")[0]);
            assert htmlImgUrl != null;
            String imgUrl = htmlImgUrl.attr("src");
            assert htmlName != null;
            String name = htmlName.text();
            assert htmlDescription != null;
            String description = htmlDescription.text();
            return new Item(name, sellingPrice, sellingPrice, url, description, new String[] {}, countRating, starRating, imgUrl);



        } catch (IOException e){
            return new Item("", 0, 0, "", "", new String[] {}, 0, 0, "");
        }




    }
}
