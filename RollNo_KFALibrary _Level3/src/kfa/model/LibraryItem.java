package kfa.model;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class LibraryItem {

    public String title;
    public String isbn;
    public double price;
    public boolean available = true;

    public int copiesAvailable = 0;

    public AtomicInteger atomicCopiesAvailable =
            new AtomicInteger(0);

    public LibraryItem(String title, String isbn, double price) {
        this.title = title;
        this.isbn = isbn;
        this.price = price;
    }

    public boolean borrowCopyB1() {

        if (copiesAvailable > 0) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }

            copiesAvailable--;
            return true;
        }

        return false;
    }

    public synchronized boolean borrowCopyB2() {

        if (copiesAvailable > 0) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }

            copiesAvailable--;
            return true;
        }

        return false;
    }

    public boolean borrowCopyB3() {

        while (true) {

            int current = atomicCopiesAvailable.get();

            if (current <= 0) {
                return false;
            }

            if (atomicCopiesAvailable.compareAndSet(
                    current,
                    current - 1)) {
                return true;
            }
        }
    }

    public abstract int getLendingPeriodDays();
}
