package com.berkay.karakaya.deliv.manager.dto.tour;

import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchTourByDateDTO {
    private Date after;
    private Date before;
}
