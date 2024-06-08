package dev.syandan.ProductServiceNamanBhalla.services;

import dev.syandan.ProductServiceNamanBhalla.dtos.ProductDto;
import org.springframework.stereotype.Service;

@Service
public class FakeStoreProductImpl implements ProductService{

    @Override
    public String getAllProducts() {
        return "";
    }

    @Override
    public String getSingleProduct(Long productId) {
        return "";
    }

    @Override
    public String addProduct(ProductDto productDto) {
        return "";
    }

    @Override
    public String updateProduct(Long productId) {
        return "";
    }

    @Override
    public String addProduct(Long productId) {
        return "";
    }
}
