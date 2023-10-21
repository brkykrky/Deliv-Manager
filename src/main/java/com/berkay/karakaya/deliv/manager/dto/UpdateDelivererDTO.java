package com.berkay.karakaya.deliv.manager.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateDelivererDTO {
    @NotNull
    @Min(value = 1)
    private Long id;
    private String firstName;
    private String lastName;
    private Boolean isAvailable;
}
