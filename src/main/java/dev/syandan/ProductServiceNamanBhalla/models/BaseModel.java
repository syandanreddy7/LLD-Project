package dev.syandan.ProductServiceNamanBhalla.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BaseModel {
    private Long id;
    private Date
            createdAt;
    private Date lastUpdatedAt;

}
