package exception;

public class WrongRoleException extends RuntimeException {
    public WrongRoleException(){
        super("The input role is not valid for security reasons");
    }
}
