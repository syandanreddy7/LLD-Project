package dev.syandan.ProductServiceNamanBhalla.controllers;

import dev.syandan.ProductServiceNamanBhalla.dtos.ProductDto;
import dev.syandan.ProductServiceNamanBhalla.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public String getAllProducts()
    {
        return "Get all the products";
    }
    @GetMapping("/{productId}")
    public String getSingleProduct(@PathVariable("productId") Long productId)
    {
        return "Get single product : " + productId;
    }
    @PostMapping()
    public String addProduct(@RequestBody ProductDto productDto)
    {
        return "Adding new product : " + productDto;
    }

    @PutMapping("/{productId}")
    public String updateProduct(@PathVariable("productId") Long productId)
    {
        return "Updating the product : " + productId;
    }

    @DeleteMapping("/{productId}")
    public String addProduct(@PathVariable("productId") Long productId )
    {
        return "Deleting the product : " + productId;
    }
}
