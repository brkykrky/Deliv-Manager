package com.berkay.karakaya.deliv.manager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SearchDeliverersDTO {
    private String firstName;
    private String lastName;
    private Date createdBefore;
    private Date createdAfter;
    private Boolean isAvailable;
}
