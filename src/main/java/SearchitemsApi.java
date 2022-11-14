import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class SearchitemsApi {


    public String apiSearch(String keywords, String marketplace) throws IOException, InterruptedException {

        String linkurl = keywordstext(keywords, marketplace);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(linkurl))
                .header("X-RapidAPI-Key", "9364e66fc1mshe8be4541ae0999ap180a9ejsn182bd6379d98")
                .header("X-RapidAPI-Host", "amazon-price1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return(response.body());



    }

    public String cleanResponse(String response){


        String modifiedResponse = response.replace("[{", "");
        modifiedResponse = modifiedResponse.replace("}]", "");
        modifiedResponse = modifiedResponse.replace('"', ' ');
        modifiedResponse = modifiedResponse.replace(", ", ",");
        modifiedResponse = modifiedResponse.replace(": ", ":");
        modifiedResponse = modifiedResponse.replace("{", "");
        modifiedResponse = modifiedResponse.replace("}", "");
        return modifiedResponse;
    }

    public ArrayList searchToList(String response){

        ArrayList<Item> itemList = new ArrayList<Item>();
        String[] pairs = response.split(" , ");

        ArrayList<String> titleList = new ArrayList<String>();
        ArrayList<String> priceList = new ArrayList<String>();
        ArrayList<String> urlList = new ArrayList<String>();
        for (int i=0;i<pairs.length;i++) {
            String pair = pairs[i];
            String[] keyValue = pair.split(" :");



            if (keyValue[0].contains("title") && !keyValue[0].contains("subtitle")){
                titleList.add(keyValue[1]);

            }
            if (keyValue[0].contains("price")){
                priceList.add(keyValue[1].replace("$", ""));
            }
            if (keyValue[0].contains("detailPageURL")){
                urlList.add(keyValue[1]);
            }
        }

        for (int i=0; i<titleList.size();i++){
            Item newItem = new Item(titleList.get(i), Double.parseDouble(priceList.get(i)), Double.parseDouble(priceList.get(i)), urlList.get(i), titleList.get(i), new String[] {});
            itemList.add(newItem);

        }
        return itemList;
    }

    private String keywordstext(String keywords, String marketplace) {

        return "https://amazon-price1.p.rapidapi.com/search?keywords="+ keywords.replace(" ", "%20") + "&marketplace=" + marketplace;
    }



}