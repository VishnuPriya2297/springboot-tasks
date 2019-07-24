package com.stackroute.Muzix.exceptions;

public class TrackAlreadyExsistsException extends Exception{
    String message;
    public TrackAlreadyExsistsException() {}
    public TrackAlreadyExsistsException(String message)
    {
        super(message);
        this.message=message;
    }

}
