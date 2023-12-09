package com.berkay.karakaya.deliv.manager.dto.tour;

import com.berkay.karakaya.deliv.manager.dto.deliverer.DelivererDTO;
import com.berkay.karakaya.deliv.manager.dto.delivery.DeliveryDTO;
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
