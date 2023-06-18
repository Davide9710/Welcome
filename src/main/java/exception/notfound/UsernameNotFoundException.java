package exception.notfound;

public class UsernameNotFoundException extends ResourceNotFoundException{
    public UsernameNotFoundException(String message) {
        super(message);
    }
}
