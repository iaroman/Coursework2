package com.example.coursework2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "The number of questions requested is greater than the number of available ones")
public class NumberIsExceededException extends RuntimeException{
    public NumberIsExceededException(String s) {
        super(s);
    }
}
