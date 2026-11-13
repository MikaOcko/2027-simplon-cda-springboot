package fr.simplon.domedespuys.dto;

import jakarta.validation.constraints.NotBlank;

public class ImageDTO {

    @NotBlank(message = "Le lien de l'image doit être renseigné.")
    public String path;

    @NotBlank(message = "Définir obligatoirement s'il s'agit de l'image par défaut.")
    public boolean isDefault;
}
