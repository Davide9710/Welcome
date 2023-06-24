package exception;

import exception.notfound.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.naming.AuthenticationException;

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
     * handler of the Authentication exception, that handles the exception thrown by Spring
     * @param e the exception thrown
     */
    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    void onAuthenticationException(AuthenticationException e) {
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
