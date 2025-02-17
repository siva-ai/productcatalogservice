package repostest;

import org.example.productcatalogservice.jparepository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductRepoTest {

    @Autowired
    private ProductRepository productRepo;

    @Test
    public void testJpa(){
        System.out.println(productRepo.findByProductbyId(20L));
    }

}
