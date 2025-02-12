package org.example.productcatalogservice.service;

import org.example.productcatalogservice.productmodels.Product;

import java.util.List;

public interface IProductservice {


    List<Product> getAllProducts();
    Product getProductbyId(Long id);

    Product replaceProduct(Long productId, Product product);
}
