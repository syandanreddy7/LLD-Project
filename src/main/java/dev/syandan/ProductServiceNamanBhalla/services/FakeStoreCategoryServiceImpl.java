package dev.syandan.ProductServiceNamanBhalla.services;

import org.springframework.stereotype.Service;

@Service
public class FakeStoreCategoryServiceImpl implements CategoryService{
    @Override
    public String getAllCategories() {
        return "";
    }

    @Override
    public String getProductsInCategory() {
        return "";
    }
}
