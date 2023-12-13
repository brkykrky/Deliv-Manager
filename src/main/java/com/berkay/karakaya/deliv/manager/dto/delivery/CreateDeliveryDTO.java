package com.berkay.karakaya.deliv.manager.dto.delivery;

import com.berkay.karakaya.deliv.manager.entity.DeliveryTour;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateDeliveryDTO {
    @NotNull(message = "pickupaddress.required")
    @Size(message = "pickup.size",min = 2,max = 64)
    private String pickupAddress;
    @NotNull(message = "storageaddress.required")
    @Size(message = "pickup.size",min = 2,max = 64)
    private String storageAddress;
    @NotNull
    private Long delivererId;
    private Long tourId;
}
