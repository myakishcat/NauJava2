import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class HTTPTask {
    public static void startTask(){
        System.out.println("--HTTP and JSON Task--");
        String urlString = "https://httpbin.org/user-agent";

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonResponse = objectMapper.readTree(response.toString());

                String userAgent = jsonResponse.get("user-agent").asText();
                System.out.println("Идентификационная строка приложения: " + userAgent);
            } else {
                System.out.println("Ошибка протокола HTTP: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}

