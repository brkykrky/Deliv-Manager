package com.berkay.karakaya.deliv.manager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class TourDTO {
    private Long id;
    private String name;
    private Date startDate;
    private Date endDate;
    private DelivererDTO assignedDeliverer;
    private List<DeliveryDTO> deliveries;
}
