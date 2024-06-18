package dev.syandan.ProductServiceNamanBhalla.controllers;

import dev.syandan.ProductServiceNamanBhalla.dtos.AddNewProductRequestDto;
import dev.syandan.ProductServiceNamanBhalla.dtos.ProductDto;
import dev.syandan.ProductServiceNamanBhalla.models.Category;
import dev.syandan.ProductServiceNamanBhalla.models.Product;
import dev.syandan.ProductServiceNamanBhalla.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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
    public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId)
    {
        MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();

        headers.add("auth-token","noaccesstoken4uheyhey");
        headers.add("random-pair-check","anotherRandomHeader");
//        GetSingleProductResponseDto response = new GetSingleProductResponseDto();
//        response.setProduct(productService.getSingleProduct(productId));
//        see notes - 1
        ResponseEntity<Product> response = new ResponseEntity(
                productService.getSingleProduct(productId),
                headers,
                HttpStatus.NOT_FOUND
        );
        return response;
    }
    @PostMapping()
    public ResponseEntity<Product> addProduct(@RequestBody ProductDto product)
    {
        Product newProduct = productService.addProduct(product);
        ResponseEntity<Product> response = new ResponseEntity(
                newProduct, HttpStatus.OK
        );
        return response;
    }

    @PatchMapping("/{productId}")
    public Product updateProduct(@PathVariable("productId") Long productId,
                                @RequestBody ProductDto productDto)
    {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setPrice(productDto.getPrice());
        product.setCategory(new Category());
        product.getCategory().setName(productDto.getCategory());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());

        return productService.updateProduct(productId,product);
    }

    @DeleteMapping("/{productId}")
    public String addProduct(@PathVariable("productId") Long productId )
    {
        return "Deleting the product : " + productId;
    }
}
