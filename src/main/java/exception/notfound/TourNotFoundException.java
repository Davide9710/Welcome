package exception.notfound;

public class TourNotFoundException extends ResourceNotFoundException {
    public TourNotFoundException(Long id){
        super("Tour not found, id: " + id);
    }
}
