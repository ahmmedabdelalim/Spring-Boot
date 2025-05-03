package com.lemo.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler
{


//    Add an exception handler using @Exceptionhandler

    @ExceptionHandler
    public ResponseEntity<StudentErorrResponse> handleException(StudentNotFoundException exc)
    {
//        create a student response error
        StudentErorrResponse error = new StudentErorrResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeSatmp(System.currentTimeMillis());

//        return new response entity
        return new ResponseEntity<>(error , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErorrResponse> handleException(Exception exc)
    {
        StudentErorrResponse error = new StudentErorrResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeSatmp(System.currentTimeMillis());

        return new ResponseEntity<>(error , HttpStatus.BAD_REQUEST);
    }
}
