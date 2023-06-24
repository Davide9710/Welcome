package exception.notfound;

/**
 * Generic resource not found exception, it defines inheritance for exceptions, helpful for error handles AOP
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message){
        super(message);
    }
}
