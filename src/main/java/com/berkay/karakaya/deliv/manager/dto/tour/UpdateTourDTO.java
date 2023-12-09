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
    @Null
    private String name;
    @Null
    private Date startDate;
    @Null
    private Date endDate;
}
