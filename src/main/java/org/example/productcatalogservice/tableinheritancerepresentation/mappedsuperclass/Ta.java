package org.example.productcatalogservice.tableinheritancerepresentation.mappedsuperclass;

import jakarta.persistence.Entity;

@Entity(name="msc_ta")
public class Ta extends User {

    String helpRequests;
}
