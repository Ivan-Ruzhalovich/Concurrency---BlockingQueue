public class Producer implements Runnable {
    MyBlockingQueue queue;

    public Producer(MyBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0;i < 20; i++) {
            queue.enqueue(new Task());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}