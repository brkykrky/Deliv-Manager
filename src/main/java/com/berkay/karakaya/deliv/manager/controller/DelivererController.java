package com.berkay.karakaya.deliv.manager.controller;

import com.berkay.karakaya.deliv.manager.dto.CreateDelivererDTO;
import com.berkay.karakaya.deliv.manager.dto.DelivererDTO;
import com.berkay.karakaya.deliv.manager.dto.SearchDeliverersDTO;
import com.berkay.karakaya.deliv.manager.dto.UpdateDelivererDTO;
import com.berkay.karakaya.deliv.manager.service.DelivererService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/deliverer")
@AllArgsConstructor
public class DelivererController {
    private final DelivererService delivererService;
    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<DelivererDTO> createDeliverer(@RequestBody @Valid CreateDelivererDTO dto){
        return ResponseEntity.ok(delivererService.create(dto));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteDeliverer(@PathVariable Long id){
        delivererService.delete(id);
    }

    @RequestMapping(value = "/",method = RequestMethod.PATCH)
    public ResponseEntity<DelivererDTO> patchDeliverer(@RequestBody @Valid UpdateDelivererDTO dto){
        return ResponseEntity.ok(delivererService.update(dto));
    }

    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public ResponseEntity<List<DelivererDTO>> searchDeliverer(@RequestBody SearchDeliverersDTO dto){
        return ResponseEntity.ok(delivererService.serach(dto));
    }
}
