package fr.simplon.domedespuys.dto.Order;

import fr.simplon.domedespuys.dto.OrderProductDTO;

import java.util.List;

public class OrderPostDTO {
    public Long addressId;
    public List<OrderProductDTO> purchaseProducts;
}
