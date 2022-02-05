import java.util.ArrayList;

public class ProcessQueue {
    private ArrayList<Node> internalQueue;
    final int size;

    public ProcessQueue(Integer size) {
        internalQueue = new ArrayList<Node>();
        this.size = size;
    }

    public void moveToProcessQueue(Node node) {
        if (internalQueue.size() >= size) {
            synchronized (this) {
                try {
                    System.out.println("The thread " + Thread.currentThread().getName() + " is waiting");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        internalQueue.add(node);
    }

    public void removeFromProcessQueue(Node node) {
        synchronized (this){
            internalQueue.remove(node);
            notify();
            System.out.println("The thread " + Thread.currentThread().getName() + " was removed");
        }

    }
}
