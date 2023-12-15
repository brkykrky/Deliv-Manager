package com.berkay.karakaya.deliv.manager.dto.deliverer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateDelivererDTO {
  private String firstName;
  private String lastName;
  private Boolean isAvailable;
}
