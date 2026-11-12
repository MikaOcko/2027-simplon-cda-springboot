package fr.simplon.domedespuys.services;

import fr.simplon.domedespuys.dto.Order.OrderPostDTO;
import fr.simplon.domedespuys.dto.Order.OrderPutDTO;
import fr.simplon.domedespuys.entity.Order;
import fr.simplon.domedespuys.interfaces.IAddressService;
import fr.simplon.domedespuys.interfaces.IOrderService;
import fr.simplon.domedespuys.interfaces.IUserService;
import fr.simplon.domedespuys.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements IOrderService {
    private OrderRepository orderRepository;
    private IAddressService addressService;
    private IUserService userService;

    @Override
    public List<Order> getCollection() {
        return orderRepository.findAll();
    }

    @Override
    public Order create(OrderPostDTO dto) {
        Order order = new Order();

        order.setAddress(addressService.getById(dto.addressId));
        order.setCreatedAt(LocalDateTime.now());
        order.setNumber("ORD-" + LocalDateTime.now().getYear() + "-" + ThreadLocalRandom.current().nextInt(000, 999));
        order.setUser(userService.getById("10"));
        orderRepository.saveAndFlush(order);

        return order;
    }

    @Override
    public Order getById(String id) {
        return orderRepository
                .findById(Long.parseLong(id))
                .orElse(null);
    }

    @Override
    public Order update(String id, OrderPutDTO dto) {
        return null;
    }
}
