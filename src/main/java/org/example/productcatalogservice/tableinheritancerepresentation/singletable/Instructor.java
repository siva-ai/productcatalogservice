package org.example.productcatalogservice.tableinheritancerepresentation.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name="st_instructor")
@DiscriminatorValue(value = "30")
public class Instructor extends User {
    String company;
}
