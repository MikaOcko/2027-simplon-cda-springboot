package fr.simplon.domedespuys.interfaces;

import fr.simplon.domedespuys.dto.Order.OrderPostDTO;
import fr.simplon.domedespuys.dto.Order.OrderPutDTO;
import fr.simplon.domedespuys.entity.Order;

public interface IOrderService extends

        ICollection<Order>,
        IGetItem<Order>,
        ICreate<Order, OrderPostDTO>,
        IUpdate<Order, OrderPutDTO>

{
}
