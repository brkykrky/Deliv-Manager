package com.berkay.karakaya.deliv.manager.dto.tour;

import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SearchTourDTO {
    @Null
    private String name;
    @Null
    private Integer deliveryNumber;
    @Null
    private Integer pageNumber;
    @Null
    private Integer pageSize;
}
