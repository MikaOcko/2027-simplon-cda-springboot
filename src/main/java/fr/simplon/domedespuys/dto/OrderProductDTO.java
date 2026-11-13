package fr.simplon.domedespuys.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class OrderProductDTO {

    @Min(value = 1, message = "La quantité doit être supérieure à 0.")
    public Integer quantity;

    @Min(value = 1, message = "Le prix doit être supérieur à 0.")
    public Integer price;

    @NotBlank(message = "Un produit doit être associé à la commande.")
    public String productId;
}
