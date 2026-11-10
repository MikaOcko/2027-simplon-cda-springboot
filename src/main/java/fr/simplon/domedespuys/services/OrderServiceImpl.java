package fr.simplon.domedespuys.services;

import fr.simplon.domedespuys.dto.Order.OrderPostDTO;
import fr.simplon.domedespuys.dto.Order.OrderPutDTO;
import fr.simplon.domedespuys.entity.Order;
import fr.simplon.domedespuys.interfaces.IOrderService;
import fr.simplon.domedespuys.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements IOrderService {
    private OrderRepository orderRepository;

    @Override
    public List<Order> getCollection() {
        return List.of();
    }

    @Override
    public Order create(OrderPostDTO dto) {
        return null;
    }

    @Override
    public Order getById(String id) {
        return null;
    }

    @Override
    public Order update(String id, OrderPutDTO dto) {
        return null;
    }
}
