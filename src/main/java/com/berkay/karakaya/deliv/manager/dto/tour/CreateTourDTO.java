package com.berkay.karakaya.deliv.manager.dto.tour;

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateTourDTO {
  private String name;
  private Date startDate;
  private Date endDate;
  private Long delivererId;
  private List<Long> deliveryIds;
}
