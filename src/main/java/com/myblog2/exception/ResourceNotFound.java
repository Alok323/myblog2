package com.myblog2.exception;

public class ResourceNotFound  extends RuntimeException{

    public ResourceNotFound(String message) {
        super(message);
    }

}
