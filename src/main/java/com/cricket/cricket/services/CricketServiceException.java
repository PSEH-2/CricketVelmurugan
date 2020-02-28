package com.cricket.cricket.services;

public class CricketServiceException extends Exception {

    private static final long serialVersionUID = -470180507998010368L;

    public CricketServiceException() {
        super();
    }

    public CricketServiceException(final String message) {
        super(message);
    }
}
