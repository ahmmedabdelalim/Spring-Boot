package com.lemo.demo.Exception;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String message)
    {
        super(message);
    }
}
