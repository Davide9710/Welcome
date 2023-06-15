package exception;

public class TouristNotFoundException extends RuntimeException {
    public TouristNotFoundException() {
    }

    public TouristNotFoundException(String message) {
        super(message);
    }
}
