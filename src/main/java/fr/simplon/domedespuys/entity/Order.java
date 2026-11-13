package fr.simplon.domedespuys.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.enumeration.EnumPurchaseStatus;
import fr.simplon.domedespuys.view.AddressView;
import fr.simplon.domedespuys.view.OrderView;
import fr.simplon.domedespuys.view.UserView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "purchase")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(OrderView.Id.class)
    private Long id;

    @Column(length = 50, unique = true, nullable = false)
    @JsonView(OrderView.Number.class)
    private String number;

    @Column(nullable = false)
    @JsonView(OrderView.CreatedAt.class)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    @JsonView(OrderView.Status.class)
    private String status = EnumPurchaseStatus.PENDING.getValue();

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    @JsonView(UserView.UserDetailView.class)
    private User user;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = true)
    @JsonView(AddressView.AddressDetailView.class)
    private Address address;

    @OneToMany(mappedBy = "purchase")
    @JsonView(OrderView.OrderProducts.class)
    private List<OrderProduct> productPurchases = new ArrayList<>();
}
