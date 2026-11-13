package fr.simplon.domedespuys.dto.Order;

import fr.simplon.domedespuys.dto.OrderProductDTO;

import java.util.List;

public class OrderPostDTO {
    public String addressId;
    public List<OrderProductDTO> purchaseProducts;
}
