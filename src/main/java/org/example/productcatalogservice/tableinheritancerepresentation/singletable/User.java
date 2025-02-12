package org.example.productcatalogservice.tableinheritancerepresentation.singletable;


import jakarta.persistence.*;

import java.util.UUID;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_type",discriminatorType = DiscriminatorType.STRING) //we use it to create new column
@Entity(name="st_user")
public class User {
    @Id
    UUID id;
    String email;
}
