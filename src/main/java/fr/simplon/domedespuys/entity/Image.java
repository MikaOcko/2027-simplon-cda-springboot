package fr.simplon.domedespuys.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.view.ImageView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(ImageView.Id.class)
    private Long id;

    @Column(nullable = false, length = 100)
    @JsonView(ImageView.Path.class)
    private String path;

    @Column(nullable = false, length = 5)
    @JsonView(ImageView.Extension.class)
    private String extension;

    @Column(nullable = false)
    @JsonView(ImageView.isDefault.class)
    private Boolean isDefault;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    @JsonView(ImageView.Product.class)
    private Product product;
}
