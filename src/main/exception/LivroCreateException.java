package main.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LivroCreateException extends RuntimeException{
    public LivroCreateException(String message){
        super(message);
    }
}
