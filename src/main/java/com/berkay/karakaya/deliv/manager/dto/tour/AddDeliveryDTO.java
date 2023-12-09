package com.berkay.karakaya.deliv.manager.dto.tour;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddDeliveryDTO {
    @NotNull
    private List<Long> deliveryIds;
}
