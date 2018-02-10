package com.basaki.error.exception;

/**
 * {@code DataNotFoundException} exception is thrown when no item is found
 * during databsase look up.
 * <p/>
 *
 * @author Indra Basak
 * @since 12/28/16
 */
public class DataNotFoundException extends RuntimeException {

    public DataNotFoundException(String message) {
        super(message);
    }
}
