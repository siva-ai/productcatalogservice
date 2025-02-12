package org.example.productcatalogservice.tableinheritancerepresentation.mappedsuperclass;

import jakarta.persistence.Entity;

@Entity(name="msc_mentor")
public class mentor extends User {
int rating;
}
