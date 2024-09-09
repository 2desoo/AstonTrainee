package restService.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import restService.config.DatabaseConfig;
import restService.dao.UserDAO;
import restService.service.impl.UserServiceImpl;

import java.io.IOException;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
    private UserServiceImpl userServiceImpl;

    @Override
    public void init() throws ServletException {
        userServiceImpl = new UserServiceImpl(new UserDAO(DatabaseConfig.getDataSource()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Получение данных из запроса и вызов userService.addUser()
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Вызов userService.getAllUsers() и отправка ответа
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Обновление пользователя
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Удаление пользователя
    }
}
