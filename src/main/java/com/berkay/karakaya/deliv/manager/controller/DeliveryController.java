package com.berkay.karakaya.deliv.manager.controller;

import com.berkay.karakaya.deliv.manager.dto.delivery.CreateDeliveryDTO;
import com.berkay.karakaya.deliv.manager.dto.delivery.DeliveryDTO;
import com.berkay.karakaya.deliv.manager.dto.delivery.SearchDeliveryDTO;
import com.berkay.karakaya.deliv.manager.dto.delivery.UpdateDeliveryDTO;
import com.berkay.karakaya.deliv.manager.service.DeliveryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/search")
    public ResponseEntity<List<DeliveryDTO>> search(@RequestBody @Valid SearchDeliveryDTO dto){
        return ResponseEntity.ok(deliveryService.search(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryDTO> get(@PathVariable Long id){
        return ResponseEntity.ok(deliveryService.get(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DeliveryDTO> patch(@PathVariable Long id, @RequestBody @Valid UpdateDeliveryDTO dto){
        return ResponseEntity.ok(deliveryService.update(id,dto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        deliveryService.delete(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<DeliveryDTO>> getAll(){
        return ResponseEntity.ok(deliveryService.getAll());
    }
}