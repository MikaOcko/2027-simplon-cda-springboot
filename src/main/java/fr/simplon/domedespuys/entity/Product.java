package fr.simplon.domedespuys.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.view.ProductView;
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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(ProductView.Id.class)
    private Long id;

    @Column(nullable = false, length = 20)
    @JsonView(ProductView.Label.class)
    private String label;

    @Column(nullable = true, columnDefinition = "TEXT")
    @JsonView(ProductView.Description.class)
    private String description;

    @Column(nullable = false)
    @JsonView(ProductView.Price.class)
    private Integer price;

    @Column(nullable = false, length = 20)
    @JsonView(ProductView.Slug.class)
    private  String slug;

    @Column(nullable = false)
    @JsonView(ProductView.CreatedAt.class)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = true)
    @JsonView(ProductView.Brand.class)
    private Brand brand;

    @OneToMany(mappedBy = "product")
    @Column(columnDefinition = "TEXT")
    @JsonView(ProductView.Images.class)
    private List<Image> images = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<OrderProduct> productPurchases = new ArrayList<>();

    /*
    public void addImage(Image image) {
        images.add(image);
        image.setProduct(this);
    }

    @JsonView(ProductView.MainImage.class)
    public Image getMainImage() {
        for (Image image : images) {
            if (image.isDefault()) {
                return image;
            }
        }
        return null;
    }
    */
}
