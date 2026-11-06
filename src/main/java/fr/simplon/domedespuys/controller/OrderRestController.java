package fr.simplon.domedespuys.controller;

import fr.simplon.domedespuys.entity.Order;
import fr.simplon.domedespuys.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/order")
public class OrderRestController {
    private final OrderRepository orderRepository;

    @GetMapping
    private List<Order> getOrders(){
        return orderRepository.findAll();
    }

    @GetMapping("/{id}")
    private Optional<Order> getOrderById(@PathVariable String id){
        return orderRepository.findById(Long.valueOf(id));
    }
}
