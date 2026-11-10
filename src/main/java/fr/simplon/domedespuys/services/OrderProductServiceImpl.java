package fr.simplon.domedespuys.services;

import fr.simplon.domedespuys.dto.OrderProductDTO;
import fr.simplon.domedespuys.entity.Order;
import fr.simplon.domedespuys.entity.OrderProduct;
import fr.simplon.domedespuys.interfaces.IOrderProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderProductServiceImpl implements IOrderProductService {
    @Override
    public OrderProduct newOrderProduct(Order order, OrderProductDTO dto) {
        return null;
    }
}
