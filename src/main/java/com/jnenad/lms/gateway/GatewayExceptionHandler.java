package com.jnenad.lms.gateway;

import com.jnenad.lms.commons.exceptions.ResourceAlreadyExistsException;
import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GatewayExceptionHandler {

  @ExceptionHandler(NoSuchElementException.class)
  public ResponseEntity<Void> handleException() {
    return ResponseEntity.notFound().build();
  }

  @ExceptionHandler(ResourceAlreadyExistsException.class)
  public ResponseEntity<Void> handleResourceNotFound() {
    return ResponseEntity.status(HttpStatus.CONFLICT).build();
  }
}
