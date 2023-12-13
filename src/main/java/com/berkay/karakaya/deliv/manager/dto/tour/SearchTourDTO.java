package com.berkay.karakaya.deliv.manager.dto.tour;

import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SearchTourDTO {
    private String name;
    private Integer deliveryNumber;
    private Integer pageNumber;
    private Integer pageSize;
}
