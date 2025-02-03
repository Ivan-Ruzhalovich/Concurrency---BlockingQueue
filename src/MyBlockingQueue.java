import java.util.LinkedList;
import java.util.List;

public class MyBlockingQueue {
    private final int capacity;
    private final List<Task> queue;


    public MyBlockingQueue() {
        this.capacity = 10;
        queue = new LinkedList<>();
    }

    public MyBlockingQueue(int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public synchronized void enqueue(Task task) {
        while (queue.size()>= capacity-1) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        queue.add(task);
        notify();

    }

    public synchronized void dequeue() {
        while (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Task task = queue.removeLast();
        notify();
    }

    public synchronized int size() {
        return queue.size();
    }
}
