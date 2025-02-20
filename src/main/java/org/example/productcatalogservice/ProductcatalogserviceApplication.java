package org.example.productcatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "org.example.productcatalogservice.jparepository")
@SpringBootApplication
public class ProductcatalogserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductcatalogserviceApplication.class, args);
    }

}
