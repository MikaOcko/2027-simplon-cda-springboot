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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private static Long id;

    @Column(nullable = false, unique = true, length = 50)
    public static String email;

    @Column(nullable = false, length = 50)
    private static String password;

    @Column(nullable = false, length = 50)
    private static String firstname;

    @Column(nullable = false, length = 50)
    public static String lastname;

    @Column(nullable = true, length = 50)
    public static String phone;

    @Column(nullable = false)
    public static LocalDateTime createdAt;



}
