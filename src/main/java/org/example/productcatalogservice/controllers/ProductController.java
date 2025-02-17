package org.example.productcatalogservice.controllers;

import org.example.productcatalogservice.dtos.CategoryDto;
import org.example.productcatalogservice.dtos.ProductDto;
import org.example.productcatalogservice.productmodels.Category;
import org.example.productcatalogservice.productmodels.Product;
import org.example.productcatalogservice.service.FakeStoreProductService;
import org.example.productcatalogservice.service.IProductservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductController {


    @Autowired
    @Qualifier("Fps") //to specify which implementation i should use
    private IProductservice productService;

    @Autowired
    @Qualifier("Sps")
    private IProductservice productservice2;

    @GetMapping("")
    public List<ProductDto> getAllProducts(Long id){

        List<ProductDto> productDtos = new ArrayList<>();
        List<Product> products = productService.getAllProducts();
        for(Product product : products){
            //ProductDto productDto = new ProductDto();
            productDtos.add(from(product));
        }
        return productDtos;

    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductbyId(@PathVariable("id") Long productId){
        //ResponseEntity<ProductDto> productDtoResponseEntity= new ResponseEntity<>();
       try {
           MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
           headers.add("Accept", "application/json");


           if (productId < 0 ) {
               throw new IllegalArgumentException("Invalid product id");
               // return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
               /*ending response entity with headers and setting status*/

           }
          // Product product= productService.getProductbyId(productId);
           Product product= productservice2.getProductbyId(productId);

           return new ResponseEntity<>(from(product), HttpStatus.OK);
       }catch(IllegalArgumentException e){
           throw e;
       }
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productdto){
       Product product=productservice2.save(from(productdto));
       return from(product);

    }

    @PutMapping("/{productId}")
    public ProductDto replaceProduct(@RequestBody ProductDto productDto, @PathVariable("productId") Long productId){
        Product product = from(productDto);
        product=productService.replaceProduct(productId,product);
        if(product == null){
            throw new IllegalArgumentException("unable to replace product as productid is invalid");
        }
        return from(product);
    }



@GetMapping("/categoryname/{id}")
public String getCategoryName(@PathVariable("id") Long id){
        String CategoryName=productservice2.getCategoryNamebyProductId(id);
        return CategoryName;
}



    private Product from(ProductDto productDto) {
        Product product = new Product();
//        product.setCreatedAt(new Date());
//        product.setLastUpdatedAt(new Date());
//        product.setState(State.ACTIVE);
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImageUrl());
        product.setDescription(productDto.getDescription());
        if(productDto.getCategory() != null) {
            Category category = new Category();
            category.setId(productDto.getCategory().getId());
            category.setName(productDto.getCategory().getName());
            product.setCategory(category);
        }
        return product;
    }

    private ProductDto from(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(product.getDescription());
        productDto.setImageUrl(product.getImageUrl());
        if(product.getCategory() != null){
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setName(product.getCategory().getName());
            categoryDto.setId(product.getCategory().getId());
            categoryDto.setDescription(product.getCategory().getDescription());
        }
        productDto.setCategory(productDto.getCategory());
        return productDto;
    }
}
