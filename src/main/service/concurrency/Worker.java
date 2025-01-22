package main.service.concurrency;

public class Worker implements Runnable {
    private final RequestQueue requestQueue;

    public Worker(RequestQueue requestQueue) {
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        while (true) {
            Runnable task = requestQueue.getTask();
            if (task != null) {
                try {
                    task.run(); // Process the task
                } catch (Exception e) {
                    System.err.println("Error while processing task: " + e.getMessage());
                }
            } else {
                try {
                    // Sleep briefly if no task is available to avoid busy waiting
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }
}
