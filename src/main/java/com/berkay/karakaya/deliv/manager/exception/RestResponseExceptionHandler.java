package com.berkay.karakaya.deliv.manager.exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestResponseExceptionHandler {
  @ExceptionHandler(CustomException.class)
  public ResponseEntity<Object> handleResourceNotFoundException(CustomException ex) {
    Map<String, Object> body = new HashMap<>();
    body.put("message", ex.getMessage());
    return new ResponseEntity<>(body, ex.getStatusCode());
  }
}
