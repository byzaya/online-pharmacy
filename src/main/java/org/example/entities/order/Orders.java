package org.example.entities.order;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.entities.pharmacy.Pharmacy;
import org.example.entities.user.UserAccount;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Orders {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private UserAccount userAccount;

  @Column(name = "creation_date")
  private Date creationDate;

  @Column(name = "delivery_date")
  private Date deliveryDate;

  @Column(name = "sum_price")
  private Double sumPrice;

  @ManyToOne
  @JoinColumn(name = "pharmacy_id", nullable = false)
  private Pharmacy pharmacy;

  @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
  private List<OrderToItem> orderToItems = new ArrayList<>();
}
