package pers.lls.concurrent.semaphore;

/**
 * @program: helloworld
 * @description:
 * @author: lils
 * @create: 2019-06-29 15:18
 */
public class BadStateException extends RuntimeException {
    public BadStateException() {
    }

    public BadStateException(String message) {
        super(message);
    }

    public BadStateException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadStateException(Throwable cause) {
        super(cause);
    }

    public BadStateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
