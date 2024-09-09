package restService.service.impl;

import restService.dao.OrderDAO;
import restService.dto.OrderDTO;
import restService.entity.Order;
import restService.entity.User;
import restService.service.OrderService;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private final OrderDAO orderDAO;

    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public void addOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setDescription(orderDTO.getDescription());
        order.setUser(new User(orderDTO.getUserId(), null, new ArrayList<>()));
        orderDAO.createOrder(order);
    }

    public OrderDTO getOrderById(int id) {
        Order order = orderDAO.getOrderById(id);
        if (order == null) {
            return null;
        }
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setDescription(order.getDescription());
        orderDTO.setUserId(order.getUser().getId());
        return orderDTO;
    }

    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderDAO.getAllOrders();
        List<OrderDTO> orderDTOs = new ArrayList<>();
        for (Order order : orders) {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setId(order.getId());
            orderDTO.setDescription(order.getDescription());
            orderDTO.setUserId(order.getUser().getId());
            orderDTOs.add(orderDTO);
        }
        return orderDTOs;
    }

    public void updateOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setId(orderDTO.getId());
        order.setDescription(orderDTO.getDescription());
        order.setUser(new User(orderDTO.getUserId(), null, new ArrayList<>()));
        orderDAO.updateOrder(order);
    }

    public void deleteOrder(int id) {
        orderDAO.deleteOrder(id);
    }
}

