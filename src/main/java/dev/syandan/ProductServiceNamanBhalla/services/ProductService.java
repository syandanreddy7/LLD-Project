package dev.syandan.ProductServiceNamanBhalla.services;

import dev.syandan.ProductServiceNamanBhalla.dtos.ProductDto;
import org.springframework.web.bind.annotation.*;

public interface ProductService {
    String getAllProducts();

    String getSingleProduct(Long productId);

    String addProduct(ProductDto productDto);

    String updateProduct(Long productId);

    String addProduct(Long productId );

}
