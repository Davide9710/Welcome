package exception.notfound;

public class EmailNotFoundException extends ResourceNotFoundException{
    public EmailNotFoundException(String email) {
        super("User not found, email: " + email);
    }
}
