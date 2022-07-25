// https://www.alura.com.br/imersao-java/aula01-consumindo-api-com-java

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.security.Key;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // Connecting to the API via http and extracting the movie list
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopMovies.json";
        URI address = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(address).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        
        // Sending the API result to the parser
        JsonParser parser = new JsonParser();
        List<Map<String, String>> movieList = parser.parse(body);
        
        // Choosing which fields to extract and showing the extracted data
        for (Map<String,String> movie : movieList) {
            System.out.println(movie.get(key:"title"));
        }  
    }
}
