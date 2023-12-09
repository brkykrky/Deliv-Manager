package com.berkay.karakaya.deliv.manager.service;

import com.berkay.karakaya.deliv.manager.dto.tour.*;
import com.berkay.karakaya.deliv.manager.entity.Deliverer;
import com.berkay.karakaya.deliv.manager.entity.Delivery;
import com.berkay.karakaya.deliv.manager.entity.DeliveryTour;
import com.berkay.karakaya.deliv.manager.repository.DelivererRepository;
import com.berkay.karakaya.deliv.manager.repository.DeliveryRepository;
import com.berkay.karakaya.deliv.manager.repository.DeliveryTourRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DeliveryTourService {
    private final DeliveryTourRepository deliveryTourRepository;
    private final DeliveryRepository deliveryRepository;
    private final DelivererRepository delivererRepository;
    private final ModelMapper modelMapper;

    public TourDTO create(CreateTourDTO dto){
        DeliveryTour tour = new DeliveryTour();

        tour.setName(dto.getName());
        tour.setStartDate(dto.getStartDate());
        tour.setEndDate(dto.getEndDate());

        if(dto.getDelivererId() != null){
            Optional<Deliverer> opt = delivererRepository.findById(dto.getDelivererId());
            if(opt.isEmpty()){
                //ToDo : throw error
            }
            tour.setAssignedDeliverer(opt.get());
        }

        if(dto.getDeliveryIds() != null && !dto.getDeliveryIds().isEmpty()){
            List<Delivery> deliveries = dto.getDeliveryIds().stream().map(x -> {
                Optional<Delivery> opt = deliveryRepository.findById(x);
                if(opt.isEmpty()){
                    //ToDo : throw error
                }
                return opt.get();
            }).toList();
            tour.setDeliveries(deliveries);
        }

        deliveryTourRepository.save(tour);
        return modelMapper.map(tour,TourDTO.class);
    }

    public TourDTO get(Long id){
        Optional<DeliveryTour> opt = deliveryTourRepository.findById(id);
        if(opt.isEmpty()){
            //ToDo : throw error
        }
        return modelMapper.map(opt.get(),TourDTO.class);
    }

    public List<TourDTO> getAll(){
        return deliveryTourRepository.findAll().stream().map(
                x -> modelMapper.map(x,TourDTO.class)).toList();
    }

    public TourDTO update(Long id, UpdateTourDTO dto){
        Optional<DeliveryTour> opt = deliveryTourRepository.findById(id);
        if(opt.isEmpty()){
            //ToDo : throw error
        }

        DeliveryTour tour = opt.get();

        if(dto.getName() != null){
            tour.setName(dto.getName());
        }
        if(dto.getStartDate() != null){
            tour.setStartDate(dto.getStartDate());
        }
        if(dto.getEndDate() != null){
            tour.setEndDate(dto.getEndDate());
        }

        deliveryTourRepository.save(tour);
        return modelMapper.map(tour,TourDTO.class);
    }

    public List<TourDTO> search(SearchTourDTO dto){
        List<DeliveryTour> tours = deliveryTourRepository.findAll();

        if(dto.getDeliveryNumber() != null){
            tours = tours.stream().filter(
                    x -> x.getDeliveries().size() == dto.getDeliveryNumber()).toList();
        }
        if(dto.getName() != null){
            tours = tours.stream().filter(
                    x -> x.getName().toLowerCase().contains(dto.getName().toLowerCase())).toList();
        }

        if(dto.getPageSize() != null && dto.getPageNumber() != null){
            PageRequest pageRequest = PageRequest.of(dto.getPageNumber(),dto.getPageSize());
            int start = (int) pageRequest.getOffset();
            int end = Math.min((start + pageRequest.getPageSize()), tours.size());
            tours = tours.subList(start,end);
        }

        return tours.stream().map(x -> modelMapper.map(x, TourDTO.class)).toList();
    }

    public TourDTO assignDelivery(Long id, AddDeliveryDTO dto){
        Optional<DeliveryTour> opt = deliveryTourRepository.findById(id);

        if(opt.isEmpty()){
            //ToDo : throw error
        }

        dto.getDeliveryIds().forEach(x -> {
           Optional<Delivery> deliv = deliveryRepository.findById(x);
           if(deliv.isEmpty()){
               //ToDo : throw error
           }
           if(opt.get().getDeliveries().contains(deliv.get())){
               //ToDo : throw error (already contains)
           }

           deliv.get().setAssignedTour(opt.get());
           deliveryRepository.save(deliv.get());
        });

        return modelMapper.map(opt.get(), TourDTO.class);
    }

    //ToDo : Le système permet de rechercher une tournée en fonction d’une date précise.
}