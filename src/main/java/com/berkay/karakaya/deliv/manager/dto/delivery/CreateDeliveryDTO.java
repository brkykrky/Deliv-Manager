package com.berkay.karakaya.deliv.manager.dto.delivery;

import com.berkay.karakaya.deliv.manager.entity.DeliveryTour;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateDeliveryDTO {
    private String pickupAddress;
    private String storageAddress;
    @NotNull
    private Long delivererId;
    @Null
    private Long tourId;
}
