package dev.syandan.ProductServiceNamanBhalla.dtos;

import dev.syandan.ProductServiceNamanBhalla.models.Category;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDto {

    private Long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
    private RatingDto rating;
    // note here the name of the attribute must be same as the response JSON
    // field from the third party API
}
