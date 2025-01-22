package main.service.concurrency;

public class RequestHandler {
    private final RequestQueue requestQueue = new RequestQueue();
    private final int THREAD_COUNT = 4; // Number of worker threads

    public RequestHandler() {
        // Start the worker threads
        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(new Worker(requestQueue)).start();
        }
    }

    // Add a task to the request queue
    public void handleRequest(Runnable task) {
        requestQueue.addTask(task);
    }
}
