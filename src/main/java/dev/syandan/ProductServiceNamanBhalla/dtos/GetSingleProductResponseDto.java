package dev.syandan.ProductServiceNamanBhalla.dtos;


import dev.syandan.ProductServiceNamanBhalla.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetSingleProductResponseDto {
    private Product product;
}
