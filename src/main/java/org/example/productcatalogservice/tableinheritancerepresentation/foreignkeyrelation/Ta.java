package org.example.productcatalogservice.tableinheritancerepresentation.foreignkeyrelation;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name="jc_ta")
@PrimaryKeyJoinColumn(name="user_id")//we r mentioning how foreignkey should be referrred as
public class Ta extends User {

    String helpRequests;
}
