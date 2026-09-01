package kfa.model;

import java.util.ArrayList;
import java.util.List;

public class ReturnsCart {

    private final List<String> returns = new ArrayList<>();
    private final int capacity;

    public ReturnsCart(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void addReturn(String title)
            throws InterruptedException {

        while (returns.size() == capacity) {
            wait();
        }

        returns.add(title);
        notifyAll();
    }

    public synchronized String collectReturn()
            throws InterruptedException {

        while (returns.isEmpty()) {
            wait();
        }

        String title = returns.remove(0);
        notifyAll();

        return title;
    }

    /*
     * wait() and notifyAll() must be inside a while loop because a thread
     * must re-check the condition after waking up before continuing.
     */
}
