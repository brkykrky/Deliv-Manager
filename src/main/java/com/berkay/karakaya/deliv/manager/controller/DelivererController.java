package com.berkay.karakaya.deliv.manager.controller;

import com.berkay.karakaya.deliv.manager.dto.deliverer.CreateDelivererDTO;
import com.berkay.karakaya.deliv.manager.dto.deliverer.DelivererDTO;
import com.berkay.karakaya.deliv.manager.dto.deliverer.SearchDeliverersDTO;
import com.berkay.karakaya.deliv.manager.dto.deliverer.UpdateDelivererDTO;
import com.berkay.karakaya.deliv.manager.service.DelivererService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/deliverer")
@AllArgsConstructor
public class DelivererController {
  private final DelivererService delivererService;

  @PostMapping
  public ResponseEntity<DelivererDTO> createDeliverer(@RequestBody @Valid CreateDelivererDTO dto) {
    return ResponseEntity.ok(delivererService.create(dto));
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deleteDeliverer(@PathVariable Long id) {
    delivererService.delete(id);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<DelivererDTO> patchDeliverer(
      @PathVariable Long id, @RequestBody @Valid UpdateDelivererDTO dto) {
    return ResponseEntity.ok(delivererService.update(id, dto));
  }

  @PostMapping("/search")
  public ResponseEntity<List<DelivererDTO>> searchDeliverer(
      @RequestBody @Valid SearchDeliverersDTO dto) {
    return ResponseEntity.ok(delivererService.search(dto));
  }

  @PostMapping("/{id}/assign-tour")
  public ResponseEntity<DelivererDTO> assignTour(@PathVariable Long id, @RequestParam Long tourId) {
    return ResponseEntity.ok(delivererService.assignTour(id, tourId));
  }

  @GetMapping("/all")
  public ResponseEntity<List<DelivererDTO>> getAll() {
    return ResponseEntity.ok(delivererService.getAll());
  }
}
