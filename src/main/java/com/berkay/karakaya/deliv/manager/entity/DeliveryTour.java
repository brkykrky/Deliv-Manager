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
public class DeliveryTour {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private Date startDate;
  private Date endDate;

  @ManyToOne
  @JoinColumn(name = "deliverer_id")
  private Deliverer assignedDeliverer;

  @OneToMany(mappedBy = "assignedTour")
  private List<Delivery> deliveries;
}
