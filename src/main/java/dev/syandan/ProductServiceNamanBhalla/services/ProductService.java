package dev.syandan.ProductServiceNamanBhalla.services;

import dev.syandan.ProductServiceNamanBhalla.dtos.ProductDto;
import dev.syandan.ProductServiceNamanBhalla.models.Category;
import dev.syandan.ProductServiceNamanBhalla.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getSingleProduct(Long productId);

    Product addProduct(ProductDto product);

    Product updateProduct(Long productId, Product product);

    Product replaceProduct(Long productId, Product product);
    boolean addProduct(Long productId );

}
