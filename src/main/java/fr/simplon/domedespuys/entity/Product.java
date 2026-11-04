package fr.simplon.domedespuys.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String label;

    @Column(nullable = true, length = 255)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false, length = 20)
    private  String slug;

    @Column(nullable = false)
    private LocalDateTime createdAt;
}
