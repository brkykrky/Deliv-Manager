package com.berkay.karakaya.deliv.manager.service;

import com.berkay.karakaya.deliv.manager.dto.CreateDelivererDTO;
import com.berkay.karakaya.deliv.manager.dto.DelivererDTO;
import com.berkay.karakaya.deliv.manager.dto.SearchDeliverersDTO;
import com.berkay.karakaya.deliv.manager.dto.UpdateDelivererDTO;
import com.berkay.karakaya.deliv.manager.entity.Deliverer;
import com.berkay.karakaya.deliv.manager.exception.DelivererNotExistException;
import com.berkay.karakaya.deliv.manager.repository.DelivererRepository;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DelivererService {
    private final DelivererRepository delivererRepository;
    public DelivererDTO create(CreateDelivererDTO dto){
        Deliverer d = new Deliverer(null,dto.getFirstName(),
                dto.getLastName(),
                Date.from(Instant.now()),
                dto.isAvailable());
        delivererRepository.save(d);
        return mapToDTO(d);
    }

    public void delete(Long id){
        Optional<Deliverer> deliverer = delivererRepository.findById(id);
        if(deliverer.isEmpty())
            return;
        delivererRepository.delete(deliverer.get());
    }

    public DelivererDTO update(UpdateDelivererDTO dto){
        Optional<Deliverer> optDeliverer = delivererRepository.findById(dto.getId());
        if(optDeliverer.isEmpty())
            throw new DelivererNotExistException();

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

        return mapToDTO(deliverer);
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

        return deliverers.stream().map(this::mapToDTO).toList();
    }

    private DelivererDTO mapToDTO(Deliverer d){
        return new DelivererDTO(d.getId(),d.getFirstName(),d.getLastName(),d.getCreationDate(),d.isAvailable());
    }
}
