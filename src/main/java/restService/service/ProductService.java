package restService.service;

import restService.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    void addProduct(ProductDTO productDTO);

    ProductDTO getProductById(int id);

    List<ProductDTO> getAllProducts();

    void updateProduct(ProductDTO productDTO);

    void deleteProduct(int id);
}
