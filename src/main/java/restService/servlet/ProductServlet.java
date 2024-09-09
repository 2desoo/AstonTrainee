package restService.servlet;

import com.google.gson.Gson;
import restService.config.DatabaseConfig;
import restService.dao.ProductDAO;
import restService.dto.ProductDTO;
import restService.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    private final ProductServiceImpl productService = new ProductServiceImpl(new ProductDAO(DatabaseConfig.getDataSource()));
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductDTO> products = productService.getAllProducts();
        resp.setContentType("application/json");
        resp.getWriter().write(gson.toJson(products));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDTO productDTO = gson.fromJson(req.getReader(), ProductDTO.class);
        productService.addProduct(productDTO);
        resp.setStatus(HttpServletResponse.SC_CREATED);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDTO productDTO = gson.fromJson(req.getReader(), ProductDTO.class);
        productService.updateProduct(productDTO);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        productService.deleteProduct(id);
        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
}

