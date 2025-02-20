package org.example.productcatalogservice.service;

import org.example.productcatalogservice.jparepository.ProductRepository;
import org.example.productcatalogservice.productmodels.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service("Sps")
@Primary
public class StorageProductService implements IProductservice{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product getProductbyId(Long id) {
        Optional<Product> productOptional= productRepository.findById(id);
        if(productOptional.isPresent()){
            return productOptional.get();
        }
        return null;
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public Product save(Product product) {
        Product productToSave = productRepository.save(product);
        return productToSave;
    }

    @Override
    public String getCategoryNamebyProductId(Long productId){
        String categoryName = productRepository.getCategoryByProductId(productId);
        return categoryName;
    }
}
