package com.berkay.karakaya.deliv.manager.controller;

import com.berkay.karakaya.deliv.manager.dto.CreateDelivererDTO;
import com.berkay.karakaya.deliv.manager.dto.DelivererDTO;
import com.berkay.karakaya.deliv.manager.service.DelivererService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/deliverer",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class DelivererController {
    private final DelivererService delivererService;
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ResponseEntity<DelivererDTO> createDeliverer(@RequestBody CreateDelivererDTO dto){
        System.out.println("Here");
        return ResponseEntity.ok(delivererService.create(dto));
    }
}
