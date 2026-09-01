package kfa.worker;

import kfa.model.Book;
import java.util.concurrent.Callable;

public class CopyCountTask implements Callable<Integer> {

    private final Book[] catalogue;

    public CopyCountTask(Book[] catalogue) {
        this.catalogue = catalogue;
    }

    @Override
    public Integer call() {

        int total = 0;

        for (Book book : catalogue) {
            total += book.atomicCopiesAvailable.get();
        }

        return total;
    }
}
