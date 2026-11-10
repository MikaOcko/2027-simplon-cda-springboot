package fr.simplon.domedespuys.entity;

import com.fasterxml.jackson.annotation.JsonView;
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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(UserView.Id.class)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    @JsonView(UserView.Email.class)
    public String email;

    @Column(nullable = false, length = 50)
    @JsonView(UserView.Password.class)
    private String password;

    @Column(nullable = false, length = 50)
    @JsonView(UserView.Firstname.class)
    private String firstname;

    @Column(nullable = false, length = 50)
    @JsonView(UserView.Lastname.class)
    public String lastname;

    @Column(nullable = true, length = 50)
    @JsonView(UserView.Phone.class)
    public String phone;

    @Column(nullable = false)
    @JsonView(UserView.CreatedAt.class)
    public LocalDateTime createdAt;

    @OneToMany(mappedBy = "user")
    @JsonView(UserView.Addresses.class)
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    @JsonView(UserView.Purchases.class)
    private List<Order> purchases = new ArrayList<>();
}
