package org.example.productcatalogservice.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.productcatalogservice.ProductcatalogserviceApplication;
import org.example.productcatalogservice.dtos.ProductDto;
import org.example.productcatalogservice.productmodels.Product;
import org.example.productcatalogservice.service.IProductservice;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
@ContextConfiguration(classes = ProductcatalogserviceApplication.class)
class ProductControllerTest {

    @Mock
    private IProductservice productservice;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllProducts() throws Exception {

        //Arrange
        Product product1=new Product();
        product1.setId(20L);
        product1.setName("iphone");
        product1.setPrice(699.00);

        Product product2=new Product();

        product2.setId(21L);
        product2.setName("iphone16");
        product2.setPrice(699.00);

        List<Product> productList=new ArrayList<>();
        productList.add(product1);
        productList.add(product2);

        when(productservice.getAllProducts()).thenReturn(productList);


        ProductDto productDto1=new ProductDto();
        productDto1.setId(product1.getId());
        productDto1.setName(product1.getName());
        productDto1.setPrice(product1.getPrice());

        ProductDto productDto2=new ProductDto();
        productDto2.setId(product2.getId());
        productDto2.setName(product2.getName());
        productDto2.setPrice(product2.getPrice());

        List<ProductDto> productDtoList=new ArrayList<>();
        productDtoList.add(productDto1);
        productDtoList.add(productDto2);





        //Act
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(content().
                        string(objectMapper.writeValueAsString(productDtoList)))
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("iphone"))
                .andExpect(jsonPath("$[1].length()").value(699.00));



    }
}