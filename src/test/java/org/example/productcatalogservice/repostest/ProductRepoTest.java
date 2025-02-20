package org.example.productcatalogservice.repostest;

import org.example.productcatalogservice.jparepository.ProductRepository;
import org.example.productcatalogservice.productmodels.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductRepoTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testJpa() {
       System.out.println(productRepository.findById(20L));

    /*   List<Product> productList = productRepository.findProductByOrderByPrice();
       for (Product product : productList) {
           System.out.println(product.getPrice());
       }*/

       System.out.println(productRepository.findProductTitleById(20L));
   }
}
