package com.berkay.karakaya.deliv.manager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "DELIVERER_DOES_NOT_EXIST")
public class DelivererNotExistException extends RuntimeException{ }