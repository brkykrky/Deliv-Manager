package com.berkay.karakaya.deliv.manager.dto.tour;

import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddDeliveryDTO {
  @NotNull(message = "deliveryIds.required")
  private List<Long> deliveryIds;
}
