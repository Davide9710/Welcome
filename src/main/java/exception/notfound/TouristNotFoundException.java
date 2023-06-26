package exception.notfound;

/**
 * Exception thrown when no guide with the given id is found
 */
public class TouristNotFoundException extends ResourceNotFoundException {
    public TouristNotFoundException(Long id){
        super("Tour not found, id: " + id);
    }
}
