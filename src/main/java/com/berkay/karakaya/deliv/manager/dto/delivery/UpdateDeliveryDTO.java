package com.berkay.karakaya.deliv.manager.dto.delivery;

import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateDeliveryDTO {
    @Null
    private String pickupAddress;
    @Null
    private String storageAddress;
}
