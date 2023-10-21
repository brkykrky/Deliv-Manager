package com.berkay.karakaya.deliv.manager.service;

import com.berkay.karakaya.deliv.manager.dto.CreateDelivererDTO;
import com.berkay.karakaya.deliv.manager.dto.DelivererDTO;
import com.berkay.karakaya.deliv.manager.entity.Deliverer;
import com.berkay.karakaya.deliv.manager.repository.DelivererRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@AllArgsConstructor
@Service
public class DelivererService {
    DelivererRepository delivererRepository;

    public DelivererDTO create(CreateDelivererDTO dto){
        Deliverer d = new Deliverer(null,dto.getFirstName(),
                dto.getLastName(),
                Date.from(Instant.now()),
                dto.isAvaliable());
        delivererRepository.save(d);
        return mapToDTO(d);
    }

    private DelivererDTO mapToDTO(Deliverer d){
        return new DelivererDTO(d.getId(),d.getFirstName(),d.getLastName(),d.getCreationDate(),d.isAvaliable());
    }
}
