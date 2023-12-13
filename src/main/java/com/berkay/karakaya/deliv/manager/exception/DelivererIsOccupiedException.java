package com.berkay.karakaya.deliv.manager.exception;

import org.springframework.http.HttpStatus;

public class DelivererIsOccupiedException extends CustomException{
    public DelivererIsOccupiedException(){super("DELIVERER_IS_OCCUPIED_FOR_A_DELIVERY_DATE", HttpStatus.BAD_REQUEST);}
}
