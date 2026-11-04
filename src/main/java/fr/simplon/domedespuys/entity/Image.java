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
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private static Long id;

    @Column(nullable = false, length = 20)
    private static String path;

    @Column(nullable = false, length = 4)
    private static String extension;

    @Column(nullable = false)
    private static Boolean isDefault;

}
