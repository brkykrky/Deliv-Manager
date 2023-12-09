package com.berkay.karakaya.deliv.manager.dto.deliverer;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateDelivererDTO {
    @NotNull(message = "firstName.required")
    @Size(message = "firstName.size",min = 2,max = 32)
    private String firstName;

    @NotNull(message = "lastName.required")
    @Size(message = "lastName.size",min = 2,max = 32)
    private String lastName;

    @NotNull(message = "isAvailable.required")
    private boolean isAvailable;
}
