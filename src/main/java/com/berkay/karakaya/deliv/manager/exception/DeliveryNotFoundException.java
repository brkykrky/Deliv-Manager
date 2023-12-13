package com.berkay.karakaya.deliv.manager.exception;

import org.springframework.http.HttpStatus;

public class DeliveryNotFoundException extends CustomException{
    public DeliveryNotFoundException(){super("DELIVERY_NOT_FOUND", HttpStatus.BAD_REQUEST);}
}
