package com.berkay.karakaya.deliv.manager.controller;

import com.berkay.karakaya.deliv.manager.dto.CreateDelivererDTO;
import com.berkay.karakaya.deliv.manager.dto.CreateDeliveryDTO;
import com.berkay.karakaya.deliv.manager.dto.DelivererDTO;
import com.berkay.karakaya.deliv.manager.dto.DeliveryDTO;
import com.berkay.karakaya.deliv.manager.service.DelivererService;
import com.berkay.karakaya.deliv.manager.service.DeliveryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/delivery")
@AllArgsConstructor
public class DeliveryController {
    private final DeliveryService deliveryService;
    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<DeliveryDTO> create(@RequestBody @Valid CreateDeliveryDTO dto){
        return ResponseEntity.ok(deliveryService.create(dto));
    }
}