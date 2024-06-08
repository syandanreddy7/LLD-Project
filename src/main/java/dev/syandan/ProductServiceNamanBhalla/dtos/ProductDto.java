package dev.syandan.ProductServiceNamanBhalla.dtos;

import dev.syandan.ProductServiceNamanBhalla.models.Category;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDto {

    private String title;
    private double price;
    private String description;
    private String imageUrl;
    private String category;
}
