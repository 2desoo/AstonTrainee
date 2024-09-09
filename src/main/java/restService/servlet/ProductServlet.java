package restService.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import restService.config.DatabaseConfig;
import restService.dao.ProductDAO;
import restService.service.impl.ProductServiceImpl;

import java.io.IOException;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    private ProductServiceImpl productServiceImpl;

    @Override
    public void init() throws ServletException {
        productServiceImpl = new ProductServiceImpl(new ProductDAO(DatabaseConfig.getDataSource()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Добавление продукта
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Получение продуктов
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Обновление продукта
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Удаление продукта
    }
}

