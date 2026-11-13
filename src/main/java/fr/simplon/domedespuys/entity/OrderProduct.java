package fr.simplon.domedespuys.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.view.OrderProductView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "purchase_product")
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(OrderProductView.Id.class)
    private Long id;

    @Column(nullable = false)
    @JsonView(OrderProductView.Quantity.class)
    private Integer quantity;

    @Column(nullable = false)
    @JsonView(OrderProductView.Price.class)
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = true)
    @JsonView(OrderProductView.Product.class)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    @JsonView(OrderProductView.Order.class)
    private Order purchase;
}
