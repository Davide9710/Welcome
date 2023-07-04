package exception;

import exception.notfound.ResourceNotFoundException;

public class CityNotFoundException extends ResourceNotFoundException {
    public CityNotFoundException(Long id) {
        super("City with id " + id + " not found");
    }
}
