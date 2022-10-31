import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SearchitemsApi {


    public String apiSearch(String keywords, String marketplace) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://amazon-price1.p.rapidapi.com/search?keywords=mechanical%20keyboard&marketplace=CA"))
                .header("X-RapidAPI-Key", "9364e66fc1mshe8be4541ae0999ap180a9ejsn182bd6379d98")
                .header("X-RapidAPI-Host", "amazon-price1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return(response.body());



    }

}