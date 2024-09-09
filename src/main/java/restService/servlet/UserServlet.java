package restService.servlet;

import com.google.gson.Gson;
import restService.config.DatabaseConfig;
import restService.dao.UserDAO;
import restService.dto.UserDTO;
import restService.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private final UserServiceImpl userService = new UserServiceImpl(new UserDAO(DatabaseConfig.getDataSource()));
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserDTO> users = userService.getAllUsers();
        resp.setContentType("application/json");
        resp.getWriter().write(gson.toJson(users));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDTO userDTO = gson.fromJson(req.getReader(), UserDTO.class);
        userService.addUser(userDTO);
        resp.setStatus(HttpServletResponse.SC_CREATED);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDTO userDTO = gson.fromJson(req.getReader(), UserDTO.class);
        userService.updateUser(userDTO);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        userService.deleteUser(id);
        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
}