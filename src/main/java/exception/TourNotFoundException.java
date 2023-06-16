package exception;

public class TourNotFoundException extends ResourceNotFoundException {
    public TourNotFoundException(Long id){
        super("Tour not found, id: " + id);
    }
}
