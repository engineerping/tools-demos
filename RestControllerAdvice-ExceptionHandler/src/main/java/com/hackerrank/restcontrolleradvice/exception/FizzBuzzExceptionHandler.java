package com.hackerrank.restcontrolleradvice.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import com.hackerrank.restcontrolleradvice.dto.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.WebUtils;

@RestControllerAdvice
public class FizzBuzzExceptionHandler extends ResponseEntityExceptionHandler {

  //TODO:: implement handler methods for FizzException, BuzzException and FizzBuzzException

  @ExceptionHandler({FizzException.class})
  public ResponseEntity<FizzException> handleFizzException(FizzException e) {
      FizzException resp = new FizzException(e.getMessage(), e.getErrorReason());
      return new ResponseEntity<FizzException>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
  }

    @ExceptionHandler({BuzzException.class})
    public ResponseEntity<BuzzException> handleBuzzException(BuzzException e) {
        BuzzException resp = new BuzzException(e.getMessage(), e.getErrorReason());
        return new ResponseEntity<BuzzException>(resp, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({FizzBuzzException.class})
    public ResponseEntity<FizzBuzzException> handleFizzBuzzException(FizzBuzzException e) {
        FizzBuzzException resp =  new FizzBuzzException(e.getMessage(), e.getErrorReason());
        return new ResponseEntity<FizzBuzzException>(resp, HttpStatus.INSUFFICIENT_STORAGE);
    }

}
