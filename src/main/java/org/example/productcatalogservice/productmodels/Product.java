package org.example.productcatalogservice.productmodels;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product extends BaseModel{

private String name;
private String description;
private String imageUrl;
private Double price;

@JsonManagedReference
@ManyToOne(cascade = CascadeType.ALL)   // used to create new category if does not exist in existing list
private Category category;


public Product() {
    setCreatedAt(new Date());
    setLastUpdatedAt(new Date());
    setState(State.ACTIVE);

}
}
