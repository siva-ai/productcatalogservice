package org.example.productcatalogservice.tableinheritancerepresentation.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name="st_mentor")
@DiscriminatorValue(value = "20")
public class mentor extends User {
int rating;
}
