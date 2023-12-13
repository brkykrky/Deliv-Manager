package com.berkay.karakaya.deliv.manager.dto.tour;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Data
public class CreateTourDTO {
    private String name;
    private Date startDate;
    private Date endDate;
    private Long delivererId;
    private List<Long> deliveryIds;
}
