package com.berkay.karakaya.deliv.manager.dto.tour;

import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UpdateTourDTO {
    private String name;
    private Date startDate;
    private Date endDate;
}
