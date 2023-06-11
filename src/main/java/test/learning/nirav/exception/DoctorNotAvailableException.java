package test.learning.nirav.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class DoctorNotAvailableException extends RuntimeException{
    public DoctorNotAvailableException() {
    }

    public DoctorNotAvailableException(String message) {
        super(message);
    }
}
