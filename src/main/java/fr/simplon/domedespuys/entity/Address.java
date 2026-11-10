package fr.simplon.domedespuys.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.view.AddressView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(AddressView.Id.class)
    private Long id;

    @Column(nullable = false, length = 50)
    @JsonView(AddressView.Line.class)
    private String line;

    @Column(nullable = true, length = 50)
    @JsonView(AddressView.ExtraLine.class)
    private String extraLine;

    @Column(nullable = false, length = 20)
    @JsonView(AddressView.City.class)
    private String city;

    @Column(nullable = false, length = 20)
    @JsonView(AddressView.ZipCode.class)
    private String zipCode;

    @Column(nullable = false, length = 20)
    @JsonView(AddressView.Country.class)
    private String country;

    @Column(nullable = true, length = 20)
    @JsonView(AddressView.Phone.class)
    private String phone;

    @Column(nullable = false, length = 20)
    @JsonView(AddressView.Firstname.class)
    private String firstname;

    @Column(nullable = false, length = 20)
    @JsonView(AddressView.Lastname.class)
    private String lastname;

    @Column(nullable = false)
    @JsonView(AddressView.CreatedAt.class)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonView(AddressView.User.class)
    private User user;

    @OneToMany(mappedBy = "address")
    @JsonView(AddressView.Orders.class)
    private List<Order> purchases = new ArrayList<>();
}
