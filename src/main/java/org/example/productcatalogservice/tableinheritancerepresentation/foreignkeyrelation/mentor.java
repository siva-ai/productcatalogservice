package org.example.productcatalogservice.tableinheritancerepresentation.foreignkeyrelation;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name="jc_mentor")
@PrimaryKeyJoinColumn(name="user_id")
public class mentor extends User {
int rating;
}
