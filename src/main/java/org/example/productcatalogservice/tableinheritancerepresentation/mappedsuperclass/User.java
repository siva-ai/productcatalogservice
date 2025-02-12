package org.example.productcatalogservice.tableinheritancerepresentation.mappedsuperclass;


import jakarta.persistence.*;

import java.util.UUID;

@MappedSuperclass
public abstract class User {
    @Id
    UUID id;
    String email;
}
