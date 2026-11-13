package fr.simplon.domedespuys.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.dto.Order.OrderPostDTO;
import fr.simplon.domedespuys.dto.Order.OrderPutDTO;
import fr.simplon.domedespuys.entity.Order;
import fr.simplon.domedespuys.interfaces.IOrderService;
import fr.simplon.domedespuys.view.OrderView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/order")
public class OrderRestController {
    private final IOrderService orderService;

    @GetMapping
    @JsonView(OrderView.OrderListView.class)
    private List<Order> getOrders(){
        return orderService.getCollection();
    }

    /*
    @GetMapping("/number/{number}")
    @JsonView(OrderView.OrderDetailView.class)
    public Optional<Order> getOrderByNumber(@PathVariable String number){
        return orderRepository.findByNumber(number);
    }
    */
    @GetMapping("/{id}")
    @JsonView(OrderView.OrderDetailView.class)
    private Order getOrderById(@PathVariable String id){
        return orderService.getById(id);
    }

    @PostMapping
    @JsonView(OrderView.OrderDetailView.class)
    public Order createOrder(@RequestBody OrderPostDTO dto) {

        return orderService.create(dto);
    }

    @PutMapping("/{id}")
    @JsonView(OrderView.OrderDetailView.class)
    public Order updateOrder(@PathVariable String id, @RequestBody OrderPutDTO dto) {
        return orderService.update(id, dto);
    }
}
