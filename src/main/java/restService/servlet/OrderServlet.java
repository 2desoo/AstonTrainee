package restService.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import restService.config.DatabaseConfig;
import restService.dao.OrderDAO;
import restService.service.impl.OrderServiceImpl;

import java.io.IOException;

@WebServlet("/orders")
public class OrderServlet extends HttpServlet {
    private OrderServiceImpl orderServiceImpl;

    @Override
    public void init() throws ServletException {
        orderServiceImpl = new OrderServiceImpl(new OrderDAO(DatabaseConfig.getDataSource()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Добавление заказа
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Получение заказов
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Обновление заказа
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Удаление заказа
    }
}
