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
        System.out.println(Thread.currentThread() + " добавил задачу номер " + task);
        System.out.println("Текущий размер очереди = " + size());
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
        System.out.println(Thread.currentThread() + " выполнил задачу номер " + task);
        System.out.println("Текущий размер очереди = " + size());
        notify();
    }

    public synchronized int size() {
        return queue.size();
    }
}
