package exception;

import exception.notfound.ResourceNotFoundException;

public class PlatformUserNotFoundException extends ResourceNotFoundException {
    public PlatformUserNotFoundException(Long id) {
        super("PlatformUser not found, id: " + id);
    }
}
