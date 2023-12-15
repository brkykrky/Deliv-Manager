package com.berkay.karakaya.deliv.manager.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {
  private HttpStatus statusCode;

  public CustomException(String message, HttpStatus status) {
    super(message);
    this.statusCode = status;
  }

  public HttpStatus getStatusCode() {
    return statusCode;
  }
}
