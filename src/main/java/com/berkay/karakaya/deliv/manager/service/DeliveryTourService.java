package com.berkay.karakaya.deliv.manager.service;

import com.berkay.karakaya.deliv.manager.dto.tour.*;
import com.berkay.karakaya.deliv.manager.entity.Deliverer;
import com.berkay.karakaya.deliv.manager.entity.Delivery;
import com.berkay.karakaya.deliv.manager.entity.DeliveryTour;
import com.berkay.karakaya.deliv.manager.exception.DelivererNotFoundException;
import com.berkay.karakaya.deliv.manager.exception.DeliveryAlreadyAssignedException;
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
public class DeliveryTourService {
  private final DeliveryTourRepository deliveryTourRepository;
  private final DeliveryRepository deliveryRepository;
  private final DelivererRepository delivererRepository;
  private final ModelMapper modelMapper;

  public TourDTO create(CreateTourDTO dto) {
    DeliveryTour tour = new DeliveryTour();

    tour.setName(dto.getName());
    tour.setStartDate(dto.getStartDate());
    tour.setEndDate(dto.getEndDate());

    if (dto.getDelivererId() != null) {
      Optional<Deliverer> opt = delivererRepository.findById(dto.getDelivererId());
      if (opt.isEmpty()) {
        throw new DelivererNotFoundException();
      }
      tour.setAssignedDeliverer(opt.get());
    }

    if (dto.getDeliveryIds() != null && !dto.getDeliveryIds().isEmpty()) {
      List<Delivery> deliveries =
          dto.getDeliveryIds().stream()
              .map(
                  x -> {
                    Optional<Delivery> opt = deliveryRepository.findById(x);
                    if (opt.isEmpty()) {
                      throw new DelivererNotFoundException();
                    }
                    return opt.get();
                  })
              .toList();
      tour.setDeliveries(deliveries);
    }

    deliveryTourRepository.save(tour);
    return modelMapper.map(tour, TourDTO.class);
  }

  public TourDTO get(Long id) {
    Optional<DeliveryTour> opt = deliveryTourRepository.findById(id);
    if (opt.isEmpty()) {
      throw new DeliveryNotFoundException();
    }
    return modelMapper.map(opt.get(), TourDTO.class);
  }

  public List<TourDTO> getAll() {
    return deliveryTourRepository.findAll().stream()
        .map(x -> modelMapper.map(x, TourDTO.class))
        .toList();
  }

  public TourDTO update(Long id, UpdateTourDTO dto) {
    Optional<DeliveryTour> opt = deliveryTourRepository.findById(id);
    if (opt.isEmpty()) {
      throw new DeliveryNotFoundException();
    }

    DeliveryTour tour = opt.get();

    if (dto.getName() != null) {
      tour.setName(dto.getName());
    }
    if (dto.getStartDate() != null) {
      tour.setStartDate(dto.getStartDate());
    }
    if (dto.getEndDate() != null) {
      tour.setEndDate(dto.getEndDate());
    }

    deliveryTourRepository.save(tour);
    return modelMapper.map(tour, TourDTO.class);
  }

  public List<TourDTO> search(SearchTourDTO dto) {
    List<DeliveryTour> tours = deliveryTourRepository.findAll();

    if (dto.getDeliveryNumber() != null) {
      tours =
          tours.stream().filter(x -> x.getDeliveries().size() == dto.getDeliveryNumber()).toList();
    }
    if (dto.getName() != null) {
      tours =
          tours.stream()
              .filter(x -> x.getName().toLowerCase().contains(dto.getName().toLowerCase()))
              .toList();
    }

    if (dto.getPageSize() != null && dto.getPageNumber() != null) {
      PageRequest pageRequest = PageRequest.of(dto.getPageNumber(), dto.getPageSize());
      int start = (int) pageRequest.getOffset();
      int end = Math.min((start + pageRequest.getPageSize()), tours.size());
      tours = tours.subList(start, end);
    }

    return tours.stream().map(x -> modelMapper.map(x, TourDTO.class)).toList();
  }

  public TourDTO assignDelivery(Long id, AddDeliveryDTO dto) {
    Optional<DeliveryTour> opt = deliveryTourRepository.findById(id);

    if (opt.isEmpty()) {
      throw new DeliveryTourNotFoundException();
    }

    dto.getDeliveryIds()
        .forEach(
            x -> {
              Optional<Delivery> deliv = deliveryRepository.findById(x);
              if (deliv.isEmpty()) {
                throw new DeliveryNotFoundException();
              }
              if (opt.get().getDeliveries().contains(deliv.get())) {
                throw new DeliveryAlreadyAssignedException();
              }

              deliv.get().setAssignedTour(opt.get());
              deliveryRepository.save(deliv.get());
            });

    return modelMapper.map(opt.get(), TourDTO.class);
  }

  public List<TourDTO> searchByDate(SearchTourByDateDTO dto) {
    List<DeliveryTour> tours = deliveryTourRepository.findAll();
    if (dto.getAfter() != null) {
      tours = tours.stream().filter(x -> x.getStartDate().after(dto.getAfter())).toList();
    }
    if (dto.getBefore() != null) {
      tours = tours.stream().filter(x -> x.getEndDate().before(dto.getBefore())).toList();
    }

    return tours.stream().map(x -> modelMapper.map(x, TourDTO.class)).toList();
  }
}
