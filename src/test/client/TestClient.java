package test.client;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestClient {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    URL url = new URL("http://localhost:8080/CCCP_2_war_exploded/billing");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setDoOutput(true);

                    // Send customer ID in request
                    OutputStream os = conn.getOutputStream();
                    os.write(("customerId=" + Thread.currentThread().getName()).getBytes());
                    os.flush();
                    os.close();

                    // Read response
                    int responseCode = conn.getResponseCode();
                    System.out.println("Response Code: " + responseCode);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
