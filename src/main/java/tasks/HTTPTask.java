package tasks;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HTTPTask {
    public static void startTask(){
        System.out.println("--HTTP and JSON Task--");
        String urlString = "https://httpbin.org/user-agent";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(URI.create(urlString))
                                            .GET()
                                            .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(response.body());
            String userAgent = jsonNode.path("user-agent").asText();
            System.out.println("Идентификационная строка приложения: " + userAgent);

        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println();
    }
}

