package kfa.worker;

import kfa.model.ReturnsCart;

public class Librarian implements Runnable {

    private final ReturnsCart cart;
    private final int itemsToProcess;

    public Librarian(ReturnsCart cart, int itemsToProcess) {
        this.cart = cart;
        this.itemsToProcess = itemsToProcess;
    }

    @Override
    public void run() {

        for (int i = 0; i < itemsToProcess; i++) {

            try {
                String title = cart.collectReturn();

                System.out.println(
                        "Librarian processed return: " + title
                );

                Thread.sleep(200);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
