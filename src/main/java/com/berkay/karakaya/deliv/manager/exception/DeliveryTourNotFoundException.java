package com.berkay.karakaya.deliv.manager.exception;

import org.springframework.http.HttpStatus;

public class DeliveryTourNotFoundException extends CustomException {
  public DeliveryTourNotFoundException() {
    super("DELIVERY_TOUR_NOT_FOUND", HttpStatus.BAD_REQUEST);
  }
}
