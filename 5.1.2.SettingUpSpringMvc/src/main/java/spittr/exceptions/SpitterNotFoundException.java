package spittr.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Spittle not found")
public class SpitterNotFoundException extends RuntimeException {
    public SpitterNotFoundException() {
    }

    public SpitterNotFoundException(String message) {
        super(message);
    }
}
