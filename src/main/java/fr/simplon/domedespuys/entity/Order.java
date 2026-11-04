package fr.simplon.domedespuys.entity;

import fr.simplon.domedespuys.enumeration.EnumPurchaseStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "purchase")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private static Long id;

    @Column(length = 20, unique = true, nullable = false)
    private static String number;

    @Column(nullable = false)
    private static LocalDateTime createdAt;

    @Column(nullable = false)
    private static EnumPurchaseStatus status = EnumPurchaseStatus.PENDING;
}
