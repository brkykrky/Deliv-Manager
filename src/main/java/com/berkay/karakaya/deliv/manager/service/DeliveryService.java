package com.berkay.karakaya.deliv.manager.service;

import com.berkay.karakaya.deliv.manager.dto.CreateDeliveryDTO;
import com.berkay.karakaya.deliv.manager.dto.DeliveryDTO;
import com.berkay.karakaya.deliv.manager.entity.Deliverer;
import com.berkay.karakaya.deliv.manager.entity.Delivery;
import com.berkay.karakaya.deliv.manager.entity.DeliveryTour;
import com.berkay.karakaya.deliv.manager.repository.DelivererRepository;
import com.berkay.karakaya.deliv.manager.repository.DeliveryRepository;
import com.berkay.karakaya.deliv.manager.repository.DeliveryTourRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;
    private final DelivererRepository delivererRepository;
    private final DeliveryTourRepository tourRepository;
    private final ModelMapper modelMapper;
    public DeliveryDTO create(CreateDeliveryDTO dto){
        Delivery delivery = new Delivery();
        Optional<Deliverer> deliverer = delivererRepository.findById(dto.getDelivererId());
        if(deliverer.isEmpty()){
            //ToDo : throw error
        }
        delivery.setAssignedDeliverer(deliverer.get());

        if(dto.getTourId() != null){
            Optional<DeliveryTour> tour = tourRepository.findById(dto.getTourId());
            if(tour.isEmpty()){
                //ToDo : throw error
            }
            delivery.setAssignedTour(tour.get());
        }

        delivery.setPickupAddress(dto.getPickupAddress());
        delivery.setStorageAddress(dto.getStorageAddress());

        deliveryRepository.save(delivery);

        return modelMapper.map(delivery,DeliveryDTO.class);
    }

    //ToDo : get byId, getAll, search, delete, update...
}
