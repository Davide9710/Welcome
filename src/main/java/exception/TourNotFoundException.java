package exception;

public class TourNotFoundException extends RuntimeException {
    public TourNotFoundException() {
    }

    public TourNotFoundException(String message) {
        super(message);
    }

    public TourNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TourNotFoundException(Throwable cause) {
        super(cause);
    }

    public TourNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
