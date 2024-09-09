package restService.service;

import restService.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    void addOrder(OrderDTO orderDTO);

    OrderDTO getOrderById(int id);

    List<OrderDTO> getAllOrders();

    void updateOrder(OrderDTO orderDTO);

    void deleteOrder(int id);
}
