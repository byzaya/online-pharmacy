package org.example.entities.pharmacy;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.entities.order.Orders;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pharmacy")
public class Pharmacy {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  private String address;

  @Column(name = "work_time")
  private String workTime;

  private String phone;

  @OneToMany(mappedBy = "pharmacy", cascade = CascadeType.ALL)
  private List<Orders> orders = new ArrayList<>();

  @OneToMany(mappedBy = "pharmacy", cascade = CascadeType.ALL)
  private List<PharmacyToItem> pharmacyToItems = new ArrayList<>();
}
