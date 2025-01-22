package main.service.concurrency;

import java.util.concurrent.ConcurrentLinkedQueue;

public class RequestQueue {
    private ConcurrentLinkedQueue<Runnable> queue = new ConcurrentLinkedQueue<>();

    // Add a task to the queue
    public void addTask(Runnable task) {
        queue.offer(task); // Thread-safe addition
    }

    // Get and remove a task from the queue
    public Runnable getTask() {
        return queue.poll(); // Thread-safe removal
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
