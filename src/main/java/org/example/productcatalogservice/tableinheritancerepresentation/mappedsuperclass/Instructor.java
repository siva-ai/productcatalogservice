package org.example.productcatalogservice.tableinheritancerepresentation.mappedsuperclass;

import jakarta.persistence.Entity;

@Entity(name="msc_instructor")
public class Instructor extends User {
    String company;
}
