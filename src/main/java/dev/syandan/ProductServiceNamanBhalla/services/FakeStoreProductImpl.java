package dev.syandan.ProductServiceNamanBhalla.services;

import dev.syandan.ProductServiceNamanBhalla.dtos.FakeStoreProductDto;
import dev.syandan.ProductServiceNamanBhalla.dtos.ProductDto;
import dev.syandan.ProductServiceNamanBhalla.models.Category;
import dev.syandan.ProductServiceNamanBhalla.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class FakeStoreProductImpl implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    private <T> ResponseEntity<T> requestForEntity(String url, HttpMethod httpMethod,
                                                   @Nullable Object request, Class<T> responseType,
                                                   Object... uriVariables)
            throws RestClientException {

        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto productDto)
    {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setPrice(productDto.getPrice());
        Category category = new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);
        product.setImageUrl(productDto.getImage());

        return product;
    }

    @Override
    public List<Product> getAllProducts() {

        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto[]> l = restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class
        );

        List<Product> answer = new ArrayList<>();
        for(FakeStoreProductDto productDto : l.getBody())
        {
            answer.add(convertFakeStoreProductDtoToProduct(productDto));
        }
        return answer;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",
                FakeStoreProductDto.class, productId);
        // the above get request method contains
        //(url, returnType, parameters_in_the_url .......)
        FakeStoreProductDto productDto = response.getBody();

//        product.setRating(productDto.getRating().getRate());
//        product.setCount(productDto.getRating().getCount());
        return convertFakeStoreProductDtoToProduct(productDto);
    }

    @Override
    public Product addProduct(ProductDto product) {
        RestTemplate restTemplate =  restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto> response = restTemplate.postForEntity("https://fakestoreapi.com/products",
                                                product,
                FakeStoreProductDto.class);
        FakeStoreProductDto productDto = response.getBody();
        return convertFakeStoreProductDtoToProduct(productDto);
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setImage(product.getImageUrl());
        fakeStoreProductDto.setCategory(product.getCategory().getName());


        // custom patch request that has been created using the low level method execute
        // here to make it for the PATCH method
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = requestForEntity(
                "https://fakestoreapi.com/products/{id}",
                HttpMethod.PATCH,
                fakeStoreProductDto,
                FakeStoreProductDto.class,
                productId
        );
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDtoResponseEntity.getBody());
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        return null;
    }

    @Override
    public boolean addProduct(Long productId) {
        return true;
    }
}
