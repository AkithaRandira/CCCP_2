package test.client;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentClientSimulator {
    private static final int CLIENT_COUNT = 10; // Number of concurrent clients
    private static final int REQUESTS_PER_CLIENT = 5; // Requests per client

    public static void main(String[] args) {
        // Create a thread pool to manage client threads
        ExecutorService executorService = Executors.newFixedThreadPool(CLIENT_COUNT);

        for (int i = 0; i < CLIENT_COUNT; i++) {
            int clientId = i + 1;
            executorService.execute(() -> simulateClient(clientId));
        }

        // Shutdown the executor service
        executorService.shutdown();
    }

    private static void simulateClient(int clientId) {
        try {
            for (int i = 0; i < REQUESTS_PER_CLIENT; i++) {
                // Construct the POST request
                URL url = new URL("http://localhost:8082/CCCP_2_war_exploded/billing");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);

                // Send the request body (e.g., customer ID)
                OutputStream os = conn.getOutputStream();
                String requestBody = "customerId=Client" + clientId + "_Request" + (i + 1);
                os.write(requestBody.getBytes());
                os.flush();
                os.close();

                // Print the server's response
                int responseCode = conn.getResponseCode();
                System.out.println("Client " + clientId + " - Request " + (i + 1) + ": Response Code " + responseCode);
            }
        } catch (Exception e) {
            System.err.println("Error for Client " + clientId + ": " + e.getMessage());
        }
    }
}
