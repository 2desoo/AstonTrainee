package restService.servlet;


import com.google.gson.Gson;
import restService.config.DatabaseConfig;
import restService.dao.OrderDAO;
import restService.dto.OrderDTO;
import restService.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/orders")
public class OrderServlet extends HttpServlet {

    private final OrderServiceImpl orderService = new OrderServiceImpl(new OrderDAO(DatabaseConfig.getDataSource()));
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<OrderDTO> orders = orderService.getAllOrders();
        resp.setContentType("application/json");
        resp.getWriter().write(gson.toJson(orders));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderDTO orderDTO = gson.fromJson(req.getReader(), OrderDTO.class);
        orderService.addOrder(orderDTO);
        resp.setStatus(HttpServletResponse.SC_CREATED);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderDTO orderDTO = gson.fromJson(req.getReader(), OrderDTO.class);
        orderService.updateOrder(orderDTO);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        orderService.deleteOrder(id);
        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
}