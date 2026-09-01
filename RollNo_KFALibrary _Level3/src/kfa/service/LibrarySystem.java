package kfa.service;

import kfa.exception.BookNotAvailableException;
import kfa.exception.ItemOverdueException;
import kfa.model.LibraryItem;

public class LibrarySystem {
    //Add a method borrowItem(kfa.model.LibraryItem item) in a new kfa.service.LibrarySystem class that throws kfa.exception.BookNotAvailableException if the
    // item's available flag is false, and otherwise marks it unavailable.

    public void burrowItem(LibraryItem item) throws BookNotAvailableException {
        if (!item.available) {
            throw new BookNotAvailableException(
                    "Items is not available : " + item.title
                );
        }
        item.available = false;
    }

    public void returnItem(LibraryItem item, int daysLate) throws ItemOverdueException {
        if(daysLate > 0 ){
            throw new ItemOverdueException(daysLate);
        }
        item.available = true;
    }

}
