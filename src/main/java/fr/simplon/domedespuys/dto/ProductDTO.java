package fr.simplon.domedespuys.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public class ProductDTO {

    @NotBlank(message = "Le nom de la marque doit ête renseigné.")
    @Length(max = 20, message = "Le nom de la marque doit comporter 20 caractères maximum.")
    public String label;

    public String description;

    @Min(value = 1, message = "Le prix doit être supérieur à zéro." )
    public Integer price;

    public String brandId;

    public List<ImageDTO> images;

}
