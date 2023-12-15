package com.berkay.karakaya.deliv.manager.service;

import com.berkay.karakaya.deliv.manager.dto.delivery.CreateDeliveryDTO;
import com.berkay.karakaya.deliv.manager.dto.delivery.DeliveryDTO;
import com.berkay.karakaya.deliv.manager.dto.delivery.SearchDeliveryDTO;
import com.berkay.karakaya.deliv.manager.dto.delivery.UpdateDeliveryDTO;
import com.berkay.karakaya.deliv.manager.entity.Delivery;
import com.berkay.karakaya.deliv.manager.entity.DeliveryTour;
import com.berkay.karakaya.deliv.manager.exception.DeliveryNotFoundException;
import com.berkay.karakaya.deliv.manager.exception.DeliveryTourNotFoundException;
import com.berkay.karakaya.deliv.manager.repository.DelivererRepository;
import com.berkay.karakaya.deliv.manager.repository.DeliveryRepository;
import com.berkay.karakaya.deliv.manager.repository.DeliveryTourRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DeliveryService {
  private final DeliveryRepository deliveryRepository;
  private final DelivererRepository delivererRepository;
  private final DeliveryTourRepository tourRepository;
  private final ModelMapper modelMapper;

  // Create a delivery
  public DeliveryDTO create(CreateDeliveryDTO dto) {
    Delivery delivery = new Delivery();
    if (dto.getTourId() != null) {
      Optional<DeliveryTour> tour = tourRepository.findById(dto.getTourId());
      if (tour.isEmpty()) {
        throw new DeliveryTourNotFoundException();
      }
      delivery.setAssignedTour(tour.get());
    }

    delivery.setPickupAddress(dto.getPickupAddress());
    delivery.setStorageAddress(dto.getStorageAddress());

    deliveryRepository.save(delivery);

    return modelMapper.map(delivery, DeliveryDTO.class);
  }

  // Get a delivery by Id
  public DeliveryDTO get(Long id) {
    Optional<Delivery> delivery = deliveryRepository.findById(id);
    if (delivery.isEmpty()) {
      throw new DeliveryNotFoundException();
    }
    return modelMapper.map(delivery.get(), DeliveryDTO.class);
  }

  public List<DeliveryDTO> getAll() {
    return deliveryRepository.findAll().stream()
        .map(x -> modelMapper.map(x, DeliveryDTO.class))
        .toList();
  }

  public void delete(Long id) {
    Optional<Delivery> delivery = deliveryRepository.findById(id);
    if (delivery.isEmpty()) {
      throw new DeliveryNotFoundException();
    }
    deliveryRepository.delete(delivery.get());
  }

  public List<DeliveryDTO> search(SearchDeliveryDTO dto) {
    List<Delivery> deliveries = deliveryRepository.findAll();

    if (dto.getPickupAddress() != null) {
      deliveries =
          deliveries.stream()
              .filter(
                  x ->
                      x.getPickupAddress()
                          .toLowerCase()
                          .contains(dto.getPickupAddress().toLowerCase()))
              .toList();
    }
    if (dto.getStorageAddress() != null) {
      deliveries =
          deliveries.stream()
              .filter(
                  x ->
                      x.getStorageAddress()
                          .toLowerCase()
                          .contains(dto.getStorageAddress().toLowerCase()))
              .toList();
    }
    if (dto.getTourName() != null) {
      deliveries =
          deliveries.stream()
              .filter(
                  x ->
                      x.getAssignedTour() != null
                          && x.getAssignedTour()
                              .getName()
                              .toLowerCase()
                              .contains(dto.getTourName().toLowerCase()))
              .toList();
    }

    if (dto.getPageSize() != null && dto.getPageNumber() != null) {
      PageRequest pageRequest = PageRequest.of(dto.getPageNumber(), dto.getPageSize());
      int start = (int) pageRequest.getOffset();
      int end = Math.min((start + pageRequest.getPageSize()), deliveries.size());
      deliveries = deliveries.subList(start, end);
    }

    return deliveries.stream().map(x -> modelMapper.map(x, DeliveryDTO.class)).toList();
  }

  public DeliveryDTO update(Long id, UpdateDeliveryDTO dto) {
    Optional<Delivery> opt = deliveryRepository.findById(id);
    if (opt.isEmpty()) {
      throw new DeliveryNotFoundException();
    }
    Delivery delivery = opt.get();

    if (dto.getPickupAddress() != null) {
      delivery.setPickupAddress(dto.getPickupAddress());
    }
    if (dto.getStorageAddress() != null) {
      delivery.setStorageAddress(dto.getStorageAddress());
    }

    deliveryRepository.save(delivery);

    return modelMapper.map(delivery, DeliveryDTO.class);
  }
}
