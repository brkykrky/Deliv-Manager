package com.berkay.karakaya.deliv.manager.dto.deliverer;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SearchDeliverersDTO {
  private String firstName;
  private String lastName;
  private Date createdBefore;
  private Date createdAfter;
  private Boolean isAvailable;
}
