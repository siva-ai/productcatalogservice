package org.example.productcatalogservice.jparepository;

import org.example.productcatalogservice.productmodels.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
