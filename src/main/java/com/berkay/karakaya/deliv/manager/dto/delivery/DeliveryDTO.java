package com.berkay.karakaya.deliv.manager.dto.delivery;

import com.berkay.karakaya.deliv.manager.dto.deliverer.DelivererDTO;
import com.berkay.karakaya.deliv.manager.dto.tour.TourDTO;
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
  private TourDTO deliveryTour;
}
