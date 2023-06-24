package exception.notfound;

/**
 * Exception thrown when no guide with the given email is found
 */
public class EmailNotFoundException extends ResourceNotFoundException{
    public EmailNotFoundException(String email) {
        super("User not found, email: " + email);
    }
}
