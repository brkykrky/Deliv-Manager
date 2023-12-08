package com.berkay.karakaya.deliv.manager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pickupAddress;
    private String storageAddress;

    @ManyToOne
    @JoinColumn(name="deliverer_id",nullable = false)
    private Deliverer assignedDeliverer;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private DeliveryTour assignedTour;
}
