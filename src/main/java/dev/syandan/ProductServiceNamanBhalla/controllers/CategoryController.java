package dev.syandan.ProductServiceNamanBhalla.controllers;

import dev.syandan.ProductServiceNamanBhalla.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public String getAllCategories()
    {
        return "Get all the categories";
    }

    @GetMapping("{categoryId}")
    public String getProductsInCategory(@PathVariable Long categoryId)
    {
        return "Get all products in category";
    }




}
