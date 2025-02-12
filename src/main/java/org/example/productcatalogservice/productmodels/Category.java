package org.example.productcatalogservice.productmodels;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
    private String name;
    private String description;
    @OneToMany(mappedBy = "category")  /*helps in preventing creation of mapping table in case of onetomany or manytoone*/
    /* "category" name is variable name mentioned in product class*/
    private List<Product> products;
}
