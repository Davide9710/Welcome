package exception.notfound;

/**
 * Exception thrown when no guide with the given id is found
 */
public class TourNotFoundException extends ResourceNotFoundException {
    public TourNotFoundException(Long id){
        super("Tour not found, id: " + id);
    }
}
