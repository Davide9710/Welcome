package exception;

import exception.notfound.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * AOP Error handling, the exception thrown by the spring components are propagated through the MVC layers until the
 * reach this handled, that defines the response entity information on a given exception. It logs the exceptions using
 * Slf4j
 */
@ControllerAdvice
@Slf4j
public class ErrorHandlerController extends ResponseEntityExceptionHandler {

    /**
     * handler of the Resource not found exception, that handles all the subclasses of that exception
     * @param e the exception thrown
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    void onResourceNotFoundException(ResourceNotFoundException e) {
        log.error(e.getMessage());
    }

    /**
     * handler of the AuthenticationException exception, that handles the exception thrown by authentication method
     * @param e the exception thrown
     */
    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    void onAuthenticationException(AuthenticationException e) {
        log.error(e.getMessage());
    }

    /**
     * handler of the BadCredentialsException exception, that handles the exception thrown by authentication control
     * @param e the exception thrown
     */
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    void onAccessDeniedException(AccessDeniedException e) {
        log.error(e.getMessage());
    }


    /**
     * handler of the EmailAlreadyUsedException exception, that handles the exception thrown when user already existing
     * @param e the exception thrown
     */
    @ExceptionHandler(EmailAlreadyUsedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    void onEmailAlreadyUsedException(EmailAlreadyUsedException e) {
        log.error(e.getMessage());
    }

    /**
     * handler of the WrongRoleException exception, that handles the exception thrown when user register with role ADMIN
     * @param e the exception thrown
     */
    @ExceptionHandler(WrongRoleException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    void onWrongRoleException(WrongRoleException e) {
        log.error(e.getMessage());
    }

    /**
     * handler of the generic exception
     * @param e the exception thrown
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    void onGenericException(Exception e) {
        log.error(e.getMessage());
    }
}
