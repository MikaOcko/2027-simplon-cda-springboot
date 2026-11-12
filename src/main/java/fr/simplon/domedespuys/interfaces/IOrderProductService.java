package fr.simplon.domedespuys.interfaces;

import fr.simplon.domedespuys.dto.OrderProductDTO;
import fr.simplon.domedespuys.entity.Order;
import fr.simplon.domedespuys.entity.OrderProduct;

public interface IOrderProductService extends
        IGetItem<OrderProduct>,
        ICollection<OrderProduct>{
    OrderProduct createOrderProduct(Order order, OrderProductDTO dto);
}
