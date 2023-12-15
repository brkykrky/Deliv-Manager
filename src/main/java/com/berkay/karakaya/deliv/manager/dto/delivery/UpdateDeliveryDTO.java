package com.berkay.karakaya.deliv.manager.dto.delivery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateDeliveryDTO {
  private String pickupAddress;
  private String storageAddress;
}
