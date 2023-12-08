package com.berkay.karakaya.deliv.manager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class DelivererNotExistException extends CustomException{
    public DelivererNotExistException(){
        super("DELIVERER_DOES_NOT_EXIST", HttpStatus.BAD_REQUEST);
    }
}