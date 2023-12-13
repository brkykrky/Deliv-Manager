package com.berkay.karakaya.deliv.manager.exception;

import org.springframework.http.HttpStatus;

public class DeliveryAlreadyAssignedException extends CustomException{
    public DeliveryAlreadyAssignedException(){super("DELIVERY_ALREADY_ASSIGNED_TO_A_TOUR", HttpStatus.BAD_REQUEST);}
}
