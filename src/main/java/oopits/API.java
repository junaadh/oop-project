//FUTURE IMAGPLEMENTATION (COMMENTED OUT)
/*

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class API {

    public static void main() {
        try {
            String apiUrl = "https://www.themealdb.com/api/json/v1/1/random.php";
            String jsonResponse = sendGetRequest(apiUrl);
            System.out.println(jsonResponse);
            // System.out.println("API Response: " + jsonResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
       
    }

    public static String sendGetRequest(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        int responseCode = conn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    response.append(line);
                }
                return response.toString();
            } finally {
                conn.disconnect();
            }
        } else {
            throw new IOException("Failed to make GET request. Response Code: " + responseCode);
        } 
    }
}

*/