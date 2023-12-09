package com.berkay.karakaya.deliv.manager.controller;

import com.berkay.karakaya.deliv.manager.dto.tour.*;
import com.berkay.karakaya.deliv.manager.service.DeliveryTourService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/delivery-tour")
@AllArgsConstructor
public class DeliveryTourController {
    private final DeliveryTourService deliveryTourService;

    @GetMapping("/{id}")
    public ResponseEntity<TourDTO> get(@PathVariable Long id){
        return ResponseEntity.ok(deliveryTourService.get(id));
    }

    @PostMapping
    public ResponseEntity<TourDTO> create(@RequestBody @Valid CreateTourDTO dto){
        return ResponseEntity.ok(deliveryTourService.create(dto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TourDTO> update(@PathVariable Long id, @RequestBody @Valid UpdateTourDTO dto){
        return ResponseEntity.ok(deliveryTourService.update(id,dto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<TourDTO>> getAll(){
        return ResponseEntity.ok(deliveryTourService.getAll());
    }

    @PostMapping("/search")
    public ResponseEntity<List<TourDTO>> search(@RequestBody @Valid SearchTourDTO dto){
        return ResponseEntity.ok(deliveryTourService.search(dto));
    }

    @PostMapping("/{id}/assign-delivery")
    public ResponseEntity<TourDTO> assignDelivery(@PathVariable Long id,@RequestBody @Valid AddDeliveryDTO dto){
        return ResponseEntity.ok(deliveryTourService.assignDelivery(id,dto));
    }
}
