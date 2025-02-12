package org.example.productcatalogservice.tableinheritancerepresentation.tableperclass;

import jakarta.persistence.Entity;

@Entity(name="tpc_mentor")
public class mentor extends User {
int rating;
}
