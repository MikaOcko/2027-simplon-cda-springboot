package fr.simplon.domedespuys.dto.Order;

import fr.simplon.domedespuys.dto.OrderProductDTO;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class OrderPostDTO {
    @NotBlank(message = "Une addresse doit être obligatoirement renseignée.")
    public String addressId;

    public List<OrderProductDTO> purchaseProducts;
}
