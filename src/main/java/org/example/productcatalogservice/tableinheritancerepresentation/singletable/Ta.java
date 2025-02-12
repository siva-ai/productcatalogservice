package org.example.productcatalogservice.tableinheritancerepresentation.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name="st_ta")
@DiscriminatorValue(value = "10")
public class Ta extends User {

    String helpRequests;
}
