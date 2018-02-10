package com.basaki.error.exception;

/**
 * {@code DatabaseException} exception is thrown when database encounters an
 * exception while performing an operation.
 * <p/>
 *
 * @author Indra Basak
 * @since 12/28/16
 */
public class DatabaseException extends RuntimeException {

    public DatabaseException(String message) {
        super(message);
    }

    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
