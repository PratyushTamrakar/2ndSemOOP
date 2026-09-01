package kfa.worker;

import kfa.model.Book;
import kfa.model.ReturnsCart;

import java.util.concurrent.atomic.AtomicInteger;

public class KioskWorker extends Thread {

    private final String kioskName;
    private final Book book;
    private final AtomicInteger successfulBorrows;
    private final int version;

    private final ReturnsCart cart;
    private final String[] returnTitles;

    public KioskWorker(String kioskName) {
        this.kioskName = kioskName;
        this.book = null;
        this.successfulBorrows = null;
        this.version = 0;
        this.cart = null;
        this.returnTitles = null;
    }

    public KioskWorker(
            String kioskName,
            Book book,
            AtomicInteger successfulBorrows,
            int version) {

        this.kioskName = kioskName;
        this.book = book;
        this.successfulBorrows = successfulBorrows;
        this.version = version;
        this.cart = null;
        this.returnTitles = null;
    }

    public KioskWorker(
            String kioskName,
            ReturnsCart cart,
            String[] returnTitles) {

        this.kioskName = kioskName;
        this.book = null;
        this.successfulBorrows = null;
        this.version = 4;
        this.cart = cart;
        this.returnTitles = returnTitles;
    }

    @Override
    public void run() {

        if (version == 0) {

            System.out.println(
                    "Started scanning at " + kioskName +
                            " on thread " +
                            Thread.currentThread().getName()
            );

            try {
                Thread.sleep(500 + (int) (Math.random() * 1001));

                System.out.println(
                        "Completed scanning at " + kioskName +
                                " on thread " +
                                Thread.currentThread().getName()
                );

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            return;
        }

        if (version == 1) {
            if (book.borrowCopyB1()) {
                successfulBorrows.incrementAndGet();
            }
            return;
        }

        if (version == 2) {
            if (book.borrowCopyB2()) {
                successfulBorrows.incrementAndGet();
            }
            return;
        }

        if (version == 3) {
            if (book.borrowCopyB3()) {
                successfulBorrows.incrementAndGet();
            }
            return;
        }

        if (version == 4) {

            for (String title : returnTitles) {

                try {
                    Thread.sleep(
                            100 + (int) (Math.random() * 401)
                    );

                    cart.addReturn(title);

                    System.out.println(
                            kioskName +
                                    " returned: " +
                                    title
                    );

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
    }
}
