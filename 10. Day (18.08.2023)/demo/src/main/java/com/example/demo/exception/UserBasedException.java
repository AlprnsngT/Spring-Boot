package com.example.demo.exception;

public class UserBasedException extends RuntimeException{
    public UserBasedException() {
        super();
    }
    public UserBasedException(String message) {
        super(message);
    }
    public UserBasedException(Throwable cause) {
        super(cause);
    }
    public UserBasedException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
