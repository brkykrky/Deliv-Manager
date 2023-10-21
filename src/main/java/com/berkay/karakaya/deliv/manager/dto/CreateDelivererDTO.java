package com.berkay.karakaya.deliv.manager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class CreateDelivererDTO {
    private String firstName;
    private String lastName;
    private boolean isAvaliable;
}
