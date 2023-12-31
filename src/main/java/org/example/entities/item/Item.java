package org.example.entities.item;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.entities.cart.CartToItem;
import org.example.entities.order.OrderToItem;
import org.example.entities.pharmacy.PharmacyToItem;
import org.example.entities.user.Speciality;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "item")
public class Item {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  private Double price;

  private String manufacturer;

  @Column(name = "picture_url")
  private String pictureUrl;

  @ManyToOne
  @JoinColumn(name = "type_id", nullable = false)
  private Type type;

  @ManyToOne
  @JoinColumn(name = "speciality_id", nullable = true)
  private Speciality speciality;

  @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
  private List<CartToItem> cartToItems = new ArrayList<>();

  @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
  private List<OrderToItem> orderToItems = new ArrayList<>();

  @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
  private List<PharmacyToItem> pharmacyToItems = new ArrayList<>();
}
