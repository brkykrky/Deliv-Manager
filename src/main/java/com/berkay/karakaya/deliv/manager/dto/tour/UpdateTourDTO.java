package com.berkay.karakaya.deliv.manager.dto.tour;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UpdateTourDTO {
  private String name;
  private Date startDate;
  private Date endDate;
}
