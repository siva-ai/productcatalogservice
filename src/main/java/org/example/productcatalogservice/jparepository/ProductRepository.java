package org.example.productcatalogservice.jparepository;

import org.example.productcatalogservice.productmodels.Category;
import org.example.productcatalogservice.productmodels.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {


    Optional<Product> findById(Long productId);

    List<Product> findAll();

   // Product replaceProduct(Product product);


    Product save(Product product);

    List<Product> findProductByOrderByPrice();

    @Query("select c.name from Category c join Product p on p.category.id=c.id where p.id=:productId")
    String getCategoryByProductId(Long productId);

    @Query("Select p.name from Product p where p.id=?1")
    String findProductTitleById(Long productId);

}
