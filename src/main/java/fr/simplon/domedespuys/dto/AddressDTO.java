package fr.simplon.domedespuys.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class AddressDTO {

    @NotBlank(message = "Le nom de rue doit être renseigné.")
    @Length(max = 50, message = "Le nom de rue ne peut pas faire plus de 50 caractères.")
    public String line;

    @Length(max = 50, message = "Le complément de rue doit comporter 50 caractères maximum.")
    public String extraLine;

    @NotBlank(message = "La ville doit être renseignée.")
    @Length(max = 20, message = "La ville doit comporter 20 caractères maximum.")
    public String city;

    @NotBlank(message = "Le code postal doit être renseigné.")
    @Length(max = 20, message = "Le code postal doit comporter 20 caractères maximum.")
    public String zipCode;

    @NotBlank(message = "Le pays doit être renseigné.")
    @Length(max = 20, message = "Le pays doit comporter 20 caractères maximum.")
    public String country;

    public String phone;

    @NotBlank(message = "Un prénom doit être renseigné.")
    @Length(max = 20, message = "Le prénom doit comporter 20 caractères maximum.")
    public String firstname;

    @NotBlank(message = "Un nom de famille doit être renseigné.")
    @Length(max = 20, message = "Le nom de famille doit comporter 20 caractères maximum.")
    public String lastname;

}
