import kfa.model.*;
import kfa.worker.KioskWorker;
import kfa.worker.ReportWorker;
import kfa.worker.Librarian;
import kfa.worker.CopyCountTask;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("\nSection A\n");

        KioskWorker kiosk1 = new KioskWorker("Kiosk-1");
        KioskWorker kiosk2 = new KioskWorker("Kiosk-2");
        KioskWorker kiosk3 = new KioskWorker("Kiosk-3");

        kiosk1.setName("KioskThread-1");
        kiosk2.setName("KioskThread-2");
        kiosk3.setName("KioskThread-3");

        kiosk1.setPriority(Thread.MAX_PRIORITY);
        kiosk2.setPriority(Thread.MIN_PRIORITY);

        Thread report1 = new Thread(
                new ReportWorker("Nightly-Report-1"),
                "ReportThread-1"
        );

        Thread report2 = new Thread(
                new ReportWorker("Nightly-Report-2"),
                "ReportThread-2"
        );

        kiosk1.start();
        kiosk2.start();
        kiosk3.start();

        report1.start();
        report2.start();

        try {
            kiosk1.join();
            kiosk2.join();
            kiosk3.join();
            report1.join();
            report2.join();

            System.out.println(
                    "All KFA services closed for the night."
            );

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread was interrupted.");
        }


        System.out.println("\nSection B1\n");

        Book bookB1 = new Book(
                "Lord of The Mysteries",
                "Cuttlefish That Loves Diving",
                "0000000000001",
                1800
        );

        bookB1.copiesAvailable = 3;

        AtomicInteger successfulB1 =
                new AtomicInteger(0);

        KioskWorker[] b1Workers =
                new KioskWorker[10];

        for (int i = 0; i < 10; i++) {
            b1Workers[i] = new KioskWorker(
                    "B1-Kiosk-" + (i + 1),
                    bookB1,
                    successfulB1,
                    1
            );
        }

        for (KioskWorker worker : b1Workers) {
            worker.start();
        }

        for (KioskWorker worker : b1Workers) {
            try {
                worker.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println(
                "B1 Successful borrows: " +
                        successfulB1.get()
        );

        System.out.println(
                "B1 Copies remaining: " +
                        bookB1.copiesAvailable
        );

        /*
         * B1 race condition: the count can go negative or more than
         * 3 successful borrows can occur because borrowCopyB1() is unsynchronized.
         */


        System.out.println("\nSection B2\n");

        Book bookB2 = new Book(
                "Solo Leveling",
                "Chugong",
                "0000000000002",
                1500
        );

        bookB2.copiesAvailable = 3;

        AtomicInteger successfulB2 =
                new AtomicInteger(0);

        KioskWorker[] b2Workers =
                new KioskWorker[10];

        for (int i = 0; i < 10; i++) {
            b2Workers[i] = new KioskWorker(
                    "B2-Kiosk-" + (i + 1),
                    bookB2,
                    successfulB2,
                    2
            );
        }

        for (KioskWorker worker : b2Workers) {
            worker.start();
        }

        for (KioskWorker worker : b2Workers) {
            try {
                worker.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println(
                "B2 Successful borrows: " +
                        successfulB2.get()
        );

        System.out.println(
                "B2 Copies remaining: " +
                        bookB2.copiesAvailable
        );

        /*
         * A Java intrinsic lock (monitor) allows only one thread at a time
         * to execute the synchronized method on the same object. Synchronizing
         * too broadly can hurt performance because unrelated operations may
         * be forced to wait unnecessarily.
         */


        System.out.println("\nSection B3\n");

        Book bookB3 = new Book(
                "Omniscient Reader's Viewpoint",
                "Sing Shong",
                "0000000000003",
                1700
        );

        bookB3.atomicCopiesAvailable.set(3);

        AtomicInteger successfulB3 =
                new AtomicInteger(0);

        KioskWorker[] b3Workers =
                new KioskWorker[10];

        for (int i = 0; i < 10; i++) {
            b3Workers[i] = new KioskWorker(
                    "B3-Kiosk-" + (i + 1),
                    bookB3,
                    successfulB3,
                    3
            );
        }

        for (KioskWorker worker : b3Workers) {
            worker.start();
        }

        for (KioskWorker worker : b3Workers) {
            try {
                worker.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println(
                "B3 Successful borrows: " +
                        successfulB3.get()
        );

        System.out.println(
                "B3 Copies remaining: " +
                        bookB3.atomicCopiesAvailable.get()
        );

        /*
         * AtomicInteger uses lock-free atomic operations such as compareAndSet(),
         * while synchronized uses a monitor lock to control access to shared data.
         */

        System.out.println("\nSection C\n");

        ReturnsCart cart = new ReturnsCart(5);

        String[] kiosk1Returns = {
                "The Beginning After the End",
                "Tower of God",
                "The World After the Fall",
                "Eleceed"
        };

        String[] kiosk2Returns = {
                "Nano Machine",
                "Lookism",
                "Mercenary Enrollment",
                "The Greatest Estate Developer"
        };

        String[] kiosk3Returns = {
                "Return of the Mount Hua Sect",
                "Solo Leveling",
                "Omniscient Reader's Viewpoint",
                "Doom Breaker"
        };

        Thread librarian = new Thread(
                new Librarian(cart, 12),
                "LibrarianThread"
        );

        KioskWorker returnKiosk1 = new KioskWorker(
                "KioskReturn-1",
                cart,
                kiosk1Returns
        );

        KioskWorker returnKiosk2 = new KioskWorker(
                "KioskReturn-2",
                cart,
                kiosk2Returns
        );

        KioskWorker returnKiosk3 = new KioskWorker(
                "KioskReturn-3",
                cart,
                kiosk3Returns
        );

        returnKiosk1.setName("ReturnThread-1");
        returnKiosk2.setName("ReturnThread-2");
        returnKiosk3.setName("ReturnThread-3");

        librarian.start();
        returnKiosk1.start();
        returnKiosk2.start();
        returnKiosk3.start();

        try {
            returnKiosk1.join();
            returnKiosk2.join();
            returnKiosk3.join();
            librarian.join();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("All returns processed.");

        System.out.println("\nSection D1\n");

        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (int i = 1; i <= 8; i++) {

            final int kioskNumber = i;

            executor.submit(() -> {

                System.out.println("Kiosk transaction " + kioskNumber + " running on " + Thread.currentThread().getName());

                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }

        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("All D1 kiosk transactions completed.");

        /*
         * Reusing a fixed pool of 4 threads for 8+ short tasks is more efficient
         * because the same threads are reused instead of repeatedly creating
         * and destroying new Thread objects.
         */

        System.out.println("\nSection D2\n");

        Book catalogueBook1 = new Book(
                "Lord of The Mysteries",
                "Cuttlefish That Loves Diving",
                "0000000000001",
                1800
        );

        Book catalogueBook2 = new Book(
                "The Beginning After the End",
                "TurtleMe",
                "0000000000004",
                1600
        );

        Book catalogueBook3 = new Book(
                "Omniscient Reader's Viewpoint",
                "Sing Shong",
                "0000000000003",
                1700
        );

        catalogueBook1.atomicCopiesAvailable.set(3);
        catalogueBook2.atomicCopiesAvailable.set(4);
        catalogueBook3.atomicCopiesAvailable.set(2);

        Book[] catalogue = {
                catalogueBook1,
                catalogueBook2,
                catalogueBook3
        };

        ExecutorService copyExecutor = Executors.newFixedThreadPool(4);
        CopyCountTask copyTask = new CopyCountTask(catalogue);
        Future<Integer> future = copyExecutor.submit(copyTask);

        System.out.println(
                "Total available copies: " +
                        future.get()
        );

        /*
         * future.get() waits if the Callable has not finished yet and then
         * returns its result. A Runnable does not return a result to the caller.
         */

        copyExecutor.shutdown();

        try {
            copyExecutor.awaitTermination(10, TimeUnit.SECONDS);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\nSection D3\n");

        ConcurrentHashMap<String, String> currentlyBorrowed =
                new ConcurrentHashMap<>();

        ExecutorService collectionExecutor =
                Executors.newFixedThreadPool(4);

        String[] borrowedBooks = {
                "Lord of The Mysteries",
                "Solo Leveling",
                "Omniscient Reader's Viewpoint",
                "The Beginning After the End",
                "Tower of God",
                "The Greatest Estate Developer",
                "Nano Machine",
                "Return of the Mount Hua Sect",
                "Eleceed",
                "Lookism"
        };

        for (int i = 1; i <= 10; i++) {

            final int kioskNumber = i;
            final String bookTitle = borrowedBooks[i - 1];

            collectionExecutor.submit(() -> {
                String kioskName = "Kiosk-" + kioskNumber;
                currentlyBorrowed.put(kioskName, bookTitle);
            });
        }

        collectionExecutor.shutdown();

        try {
            collectionExecutor.awaitTermination(10, TimeUnit.SECONDS);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("D3 Final currentlyBorrowed size: " + currentlyBorrowed.size());

        /*
         * An ordinary HashMap or HashSet is unsafe when multiple threads modify
         * it concurrently because its internal structure is not thread-safe.
         * Concurrent modifications, especially during resizing, can cause lost
         * updates, corrupted data, or inconsistent results.
         */

    }
}

