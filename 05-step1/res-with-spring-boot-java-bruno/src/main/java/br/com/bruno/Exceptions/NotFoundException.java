package br.com.bruno.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NotFoundException(String message) {
        super(message);
        setStackTrace(new StackTraceElement[0]); // Remove stack trace
    }

    public NotFoundException() {
        super("Resource not found");
        setStackTrace(new StackTraceElement[0]); // Remove stack trace
    }
}
