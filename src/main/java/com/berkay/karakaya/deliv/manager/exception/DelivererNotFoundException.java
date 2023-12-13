package com.berkay.karakaya.deliv.manager.exception;

import org.springframework.http.HttpStatus;

public class DelivererNotFoundException extends CustomException{
    public DelivererNotFoundException(){
        super("DELIVERER_NOT_FOUND", HttpStatus.BAD_REQUEST);
    }
}