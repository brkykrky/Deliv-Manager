package com.berkay.karakaya.deliv.manager.service;

import com.berkay.karakaya.deliv.manager.dto.deliverer.CreateDelivererDTO;
import com.berkay.karakaya.deliv.manager.dto.deliverer.DelivererDTO;
import com.berkay.karakaya.deliv.manager.dto.deliverer.SearchDeliverersDTO;
import com.berkay.karakaya.deliv.manager.dto.deliverer.UpdateDelivererDTO;
import com.berkay.karakaya.deliv.manager.entity.Deliverer;
import com.berkay.karakaya.deliv.manager.entity.DeliveryTour;
import com.berkay.karakaya.deliv.manager.exception.DelivererIsOccupiedException;
import com.berkay.karakaya.deliv.manager.exception.DelivererNotFoundException;
import com.berkay.karakaya.deliv.manager.exception.DeliveryTourNotFoundException;
import com.berkay.karakaya.deliv.manager.repository.DelivererRepository;
import com.berkay.karakaya.deliv.manager.repository.DeliveryTourRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DelivererService {
    private final DelivererRepository delivererRepository;
    private final DeliveryTourRepository deliveryTourRepository;
    private final ModelMapper modelMapper;
    public DelivererDTO create(CreateDelivererDTO dto){
        Deliverer d = new Deliverer(null,dto.getFirstName(),
                dto.getLastName(),
                Date.from(Instant.now()),
                dto.isAvailable(),
                new ArrayList<>(),
                new ArrayList<>());
        delivererRepository.save(d);
        return modelMapper.map(d,DelivererDTO.class);
    }

    public void delete(Long id){
        Optional<Deliverer> deliverer = delivererRepository.findById(id);
        if(deliverer.isEmpty())
            return;
        delivererRepository.delete(deliverer.get());
    }

    public DelivererDTO update(Long id, UpdateDelivererDTO dto){
        Optional<Deliverer> optDeliverer = delivererRepository.findById(id);
        if(optDeliverer.isEmpty())
            throw new DelivererNotFoundException();

        Deliverer deliverer = optDeliverer.get();

        if(dto.getIsAvailable() != null)
            deliverer.setAvailable(dto.getIsAvailable());

        if(dto.getFirstName() != null && dto.getFirstName().length() >= 2){
            deliverer.setFirstName(dto.getFirstName());
        }

        if(dto.getLastName() != null && dto.getLastName().length() >= 2){
            deliverer.setLastName(dto.getLastName());
        }

        delivererRepository.save(deliverer);

        return modelMapper.map(deliverer,DelivererDTO.class);
    }

    public List<DelivererDTO> serach(SearchDeliverersDTO dto){
        List<Deliverer> deliverers = delivererRepository.findAll();
        if(dto.getFirstName() != null){
            deliverers = deliverers.stream().filter(
                    x -> x.getFirstName().toLowerCase().
                            contains(dto.getFirstName().toLowerCase())).toList();
        }
        if(dto.getLastName() != null){
            deliverers = deliverers.stream().filter(
                        x -> x.getLastName().toLowerCase().
                            contains(dto.getLastName().toLowerCase())).toList();
        }
        if(dto.getIsAvailable() != null){
            deliverers = deliverers.stream().filter(x -> x.isAvailable() == dto.getIsAvailable()).toList();
        }
        if(dto.getCreatedAfter() != null){
            deliverers = deliverers.stream().filter(x -> x.getCreationDate().after(dto.getCreatedAfter())).toList();
        }
        if(dto.getCreatedBefore() != null){
            deliverers = deliverers.stream().filter(x -> x.getCreationDate().before(dto.getCreatedBefore())).toList();
        }

        return deliverers.stream().map(x -> modelMapper.map(x,DelivererDTO.class)).toList();
    }
    public DelivererDTO assignTour(Long id, Long tourId){
        Optional<Deliverer> delivererOpt = delivererRepository.findById(id);
        if(delivererOpt.isEmpty()){
            throw new DelivererNotFoundException();
        }

        Optional<DeliveryTour> tourOpt = deliveryTourRepository.findById(tourId);
        if(tourOpt.isEmpty()){
            throw new DeliveryTourNotFoundException();
        }

        if(tourOpt.get().getAssignedDeliverer() != null){
            //ToDo : throw error (tour already has deliverer)
            //ToDo : ask if we change the assigned deliverer in this case ?
        }

        for(DeliveryTour tour : delivererOpt.get().getDeliveryTours()){
            if(tourOpt.get().getStartDate().before(tour.getEndDate()) ||
                tourOpt.get().getEndDate().after(tour.getStartDate())){
                throw new DelivererIsOccupiedException();
            }
        }

        tourOpt.get().setAssignedDeliverer(delivererOpt.get());
        deliveryTourRepository.save(tourOpt.get());
        return modelMapper.map(delivererOpt.get(),DelivererDTO.class);
    }
}
