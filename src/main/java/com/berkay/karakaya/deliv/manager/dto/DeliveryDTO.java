package com.berkay.karakaya.deliv.manager.dto;

import com.berkay.karakaya.deliv.manager.entity.Deliverer;
import com.berkay.karakaya.deliv.manager.entity.DeliveryTour;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class DeliveryDTO {
    private Long id;
    private String pickupAddress;
    private String storageAddress;
    private DelivererDTO deliverer;
    private TourDTO deliveryTour;
}
