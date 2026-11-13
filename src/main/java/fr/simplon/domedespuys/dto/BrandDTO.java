package fr.simplon.domedespuys.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class BrandDTO {

    @NotBlank(message = "Le label doit être renseigné.")
    @Length(max = 20, message = "Le label ne peut pas faire plus de 20 caractères.")
    public String label;

    public String logo;
}
