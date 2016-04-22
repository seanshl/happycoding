package com.beaverbay.utility;

public class UserException extends Exception{
    private static final long serialVersionUID = 571380959333330418L;
    
    private String message;
    
    public UserException(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
}
