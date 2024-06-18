package dev.syandan.ProductServiceNamanBhalla.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseModel{
    private String title;
    private double price;
    private String description;
    private Category category;
    private String imageUrl;
    private boolean deleted;
    private double rating;
    private long count;
}
