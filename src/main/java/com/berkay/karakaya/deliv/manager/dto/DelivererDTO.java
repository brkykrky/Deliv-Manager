package com.berkay.karakaya.deliv.manager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class DelivererDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Date creationDate;
    private boolean isAvaliable;
}
