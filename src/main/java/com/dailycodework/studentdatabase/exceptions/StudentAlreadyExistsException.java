package com.dailycodework.studentdatabase.exceptions;

public class StudentAlreadyExistsException extends RuntimeException{
    public StudentAlreadyExistsException(String message) {
        super(message);
    }
}
