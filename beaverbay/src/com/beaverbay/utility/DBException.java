package com.beaverbay.utility;

public class DBException extends Exception{
    private static final long serialVersionUID = 4172425959385921323L;
    
    private String message;
    
    public DBException(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
}
