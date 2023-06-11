package test.learning.nirav.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class AppointmentAlreadyAvailableException extends RuntimeException{
    public AppointmentAlreadyAvailableException() {
    }

    public AppointmentAlreadyAvailableException(String message) {
        super(message);
    }
}
