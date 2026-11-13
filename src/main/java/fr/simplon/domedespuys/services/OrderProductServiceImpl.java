package fr.simplon.domedespuys.services;

import fr.simplon.domedespuys.dto.OrderProductDTO;
import fr.simplon.domedespuys.entity.Order;
import fr.simplon.domedespuys.entity.OrderProduct;
import fr.simplon.domedespuys.interfaces.IOrderProductService;
import fr.simplon.domedespuys.interfaces.IProductService;
import fr.simplon.domedespuys.repository.OrderProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderProductServiceImpl implements IOrderProductService {

    private final OrderProductRepository orderProductRepository;
    private final IProductService productService;

    @Override
    public OrderProduct createOrderProduct(Order purchase, OrderProductDTO dto) {
        OrderProduct orderProduct = new OrderProduct();

        orderProduct.setQuantity(dto.quantity);
        orderProduct.setPrice(dto.price);
        orderProduct.setProduct(productService.getById(dto.productId));
        orderProduct.setPurchase(purchase);

        orderProductRepository.saveAndFlush(orderProduct);

        return orderProduct;
    }
}
