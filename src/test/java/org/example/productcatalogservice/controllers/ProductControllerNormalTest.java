package org.example.productcatalogservice.controllers;

import org.example.productcatalogservice.dtos.ProductDto;
import org.example.productcatalogservice.productmodels.Product;
import org.example.productcatalogservice.service.IProductservice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerNormalTest {

    @Autowired
    private ProductController productController;

    @MockBean
   private IProductservice productservice;

    @Test
   public void Test_GetProductById_ReturnsSuccessfully(){

       //Arrange
       Long productId = 4L;
       Product product= new Product();
       product.setId(productId);
       product.setName("Iphone");

        when(productservice.getProductbyId(productId)).thenReturn(product);

       //act
       ResponseEntity<ProductDto> response=productController.getProductbyId(productId);

       //assert
       assertNotNull(response);
       assertNotNull(response.getBody());
       assertEquals(productId,response.getBody().getId());
       assertEquals("Iphone",response.getBody().getName());
   }

   @Test
   public void Test_GetProductById_CalledWithInavalidId_ReturnsInIllegalArgumentException()
   {
     Exception e= assertThrows(IllegalArgumentException.class, ()->productController.getProductbyId(-1L));
   }


}