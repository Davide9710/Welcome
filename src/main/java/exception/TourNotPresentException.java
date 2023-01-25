package exception;

public class TourNotPresentException extends RuntimeException {
    public TourNotPresentException() {
    }

    public TourNotPresentException(String message) {
        super(message);
    }

    public TourNotPresentException(String message, Throwable cause) {
        super(message, cause);
    }

    public TourNotPresentException(Throwable cause) {
        super(cause);
    }

    public TourNotPresentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
