package com.stackroute.Muzix;

import com.stackroute.Muzix.exceptions.TrackAlreadyExsistsException;
import com.stackroute.Muzix.exceptions.TrackNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalException
{
    @ExceptionHandler(TrackAlreadyExsistsException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ExceptionResponse handleResourceNotFound(final TrackAlreadyExsistsException exception,
                                                                  final HttpServletRequest request) {
        ExceptionResponse error=new ExceptionResponse();
        error.setErrorMessage(exception.getMessage());
        error.callerURL(request.getRequestURI());
        return error;
    }
    @ExceptionHandler(TrackNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody ExceptionResponse handleResourceNotFound(final TrackNotFoundException exception,
                                                                  final HttpServletRequest request) {

        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage(exception.getMessage());
        error.callerURL(request.getRequestURI());

        return error;
    }


}
