package test.learning.nirav.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InValidRequestException extends RuntimeException{
    public InValidRequestException() {
    }

    public InValidRequestException(String message) {
        super(message);
    }
}
