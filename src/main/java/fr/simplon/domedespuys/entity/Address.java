package fr.simplon.domedespuys.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private static Long id;

    @Column(nullable = false, length = 20)
    private static String line;

    @Column(nullable = true, length = 20)
    private static String extraLine;

    @Column(nullable = false, length = 20)
    private static String city;

    @Column(nullable = false, length = 20)
    private static String zipCode;

    @Column(nullable = false, length = 20)
    private static String country;

    @Column(nullable = true, length = 20)
    private static String phone;

    @Column(nullable = false, length = 20)
    private static String firstname;

    @Column(nullable = false, length = 20)
    private static String lastname;

    @Column(nullable = false)
    private static LocalDateTime createdAt;
}
