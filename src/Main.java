
/// This is the API example code. It has nothing to do with JavaFX

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;

public class Main {
    public static void main(String[] args) {
        String url = "https://www.thesportsdb.com/api/v1/json/3/eventsseason.php?id=4328&s=2024-2025";

        try {

            SSLContext sslContext = SSLContext.getInstance("TLS");
            TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        public X509Certificate[] getAcceptedIssuers(){return null;}
                        public void checkClientTrusted(X509Certificate[] certs, String authType) {}
                        public void checkServerTrusted(X509Certificate[] certs, String authType) {}
                    }
            };
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

            //Create HTTP client with the custom SSL context
            HttpClient client = HttpClient.newBuilder()
                    .sslContext(sslContext)
                    .build();

            //HttpClient client = HttpClient.newHttpClient();

            //Build HTTP request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            // Send request and get response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // check if the response was successful
            if (response.statusCode() == 200) {
                //parse JSON
                JSONObject jsonResponse = new JSONObject(response.body());
                JSONArray events = jsonResponse.getJSONArray("events");

                //Display the events
                System.out.println("Upcoming English Premier League Events:");
                for (int i = 0; i < Math.min(events.length(), 5); i++) {
                    JSONObject event = events.getJSONObject(i);
                    String eventName = event.getString("strEvent");
                    String date = event.getString("dateEvent");
                    String time = event.optString("strTime", "TBD");
                    System.out.printf("Event: %s | Date: %s | Time: %s%n", eventName, date, time);
                }
            } else {
                System.out.print("Failed to fetch data. HTTP Status: " + response.statusCode());
            }
        } catch (Exception e) {
            System.err.println("Error fetching sports data: " + e.getMessage());
        }
    }
}