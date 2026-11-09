package fr.simplon.domedespuys.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.entity.Brand;
import fr.simplon.domedespuys.entity.Order;
import fr.simplon.domedespuys.repository.OrderRepository;
import fr.simplon.domedespuys.view.BrandView;
import fr.simplon.domedespuys.view.OrderView;
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
    @JsonView(OrderView.OrderListView.class)
    private List<Order> getOrders(){
        return orderRepository.findAll();
    }

    @GetMapping("/number/{number}")
    @JsonView(OrderView.OrderDetailView.class)
    public Optional<Order> getOrderByNumber(@PathVariable String number){
        return orderRepository.findByNumber(number);
    }

    @GetMapping("/{id}")
    @JsonView(OrderView.OrderDetailView.class)
    private Optional<Order> getOrderById(@PathVariable String id){
        return orderRepository.findById(Long.valueOf(id));
    }
}
