package com.berkay.karakaya.deliv.manager.dto.tour;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchTourByDateDTO {
  private Date after;
  private Date before;
}
