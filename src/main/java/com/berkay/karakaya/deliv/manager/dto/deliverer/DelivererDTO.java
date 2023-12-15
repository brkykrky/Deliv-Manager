package com.berkay.karakaya.deliv.manager.dto.deliverer;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DelivererDTO {
  private Long id;
  private String firstName;
  private String lastName;
  private Date creationDate;
  private boolean isAvailable;
}
