package com.berkay.karakaya.deliv.manager.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Deliverer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String firstName;
  private String lastName;
  private Date creationDate;
  private boolean isAvailable;

  @OneToMany(mappedBy = "assignedDeliverer")
  private List<DeliveryTour> deliveryTours;

  @OneToMany(mappedBy = "assignedDeliverer")
  private List<Delivery> deliveries;
}
