package com.basaki.error;

/**
 * {@code ErrorInfo} represents an error response object which is exposed to
 * the external client. It is human readable and informative without
 * exposing service implementation details, e.g.,
 * exception type, stack trace, etc.
 * <p/>
 *
 * @author Indra Basak
 * @since 12/27/16
 */
public class ErrorInfo {

    private String path;

    private int code;

    private String type;

    private String message;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
