package exception.notfound;

public class TouristNotFoundException extends ResourceNotFoundException {
    public TouristNotFoundException(Long id){
        super("Tour not found, id: " + id);
    }
}