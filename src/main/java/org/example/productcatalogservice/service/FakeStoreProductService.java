/**
 *
 */
package org.example.productcatalogservice.service;


import org.example.productcatalogservice.dtos.FakeStoreProductDto;
import org.example.productcatalogservice.productmodels.Category;
import org.example.productcatalogservice.productmodels.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements IProductservice{

    @Autowired  //-- it will try to find bean of restemplateBuilder inject this to fakestore productservice
    private RestTemplateBuilder restTemplateBuilder;

//Do we need to create Bean for RestTemplateBuilder in config class using @Bean?

   /*  we define RestTemplateBuilder in config file if we want to override a behaviour
    of restTemplateBuilder else we can use it as it*/

/*    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
  }*/

    public List<Product> getAllProducts() {
     RestTemplate restTemplate = restTemplateBuilder.build();
     List<Product> products = new ArrayList<>();
     FakeStoreProductDto[] fakeStoreProductDtoResponseEntity=restTemplate.getForEntity("https://fakestoreapi.com/products", FakeStoreProductDto[].class).getBody();

     for(FakeStoreProductDto fakeStoreProductDto:fakeStoreProductDtoResponseEntity){
         products.add(from(fakeStoreProductDto));


     }
return products;
    }

    private Product from(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setId(fakeStoreProductDto.getId());
        product.setName(fakeStoreProductDto.getTitle());
        product.setImageUrl(fakeStoreProductDto.getImage());
        product.setPrice(fakeStoreProductDto.getPrice());
        Category category = new Category();

        category.setName(fakeStoreProductDto.getCategory());
        category.setDescription(fakeStoreProductDto.getDescription());
        product.setCategory(category);
        return product;


    }


    public Product createProduct(Product product) {
        return product;
    }


    public Product getProductbyId(Long id) {

        RestTemplate restTemplate= restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity=restTemplate.getForEntity("https://fakestoreapi.com/products/{productId}", FakeStoreProductDto.class, id);
        if(fakeStoreProductDtoResponseEntity.getStatusCode().equals(HttpStatusCode.valueOf(200)) && fakeStoreProductDtoResponseEntity.getBody() != null){
            return from(fakeStoreProductDtoResponseEntity.getBody());
        }
        return null;
    }


    public <T> ResponseEntity<T> postForEntity(String url,HttpMethod httpMethod, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }


    @Override
    public Product replaceProduct(Long productId, Product product) {
         FakeStoreProductDto fakeStoreProductDto=from(product);
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity=postForEntity("https://fakestoreapi.com/products/{productId}",HttpMethod.PUT,fakeStoreProductDto, FakeStoreProductDto.class, productId);

            return from(fakeStoreProductDtoResponseEntity.getBody());

    }


    private FakeStoreProductDto from(Product product) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setTitle(product.getName());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setImage(product.getImageUrl());
        if(product.getCategory() != null) {
            fakeStoreProductDto.setCategory(product.getCategory().getName());
        }
        return fakeStoreProductDto;
    }
}
