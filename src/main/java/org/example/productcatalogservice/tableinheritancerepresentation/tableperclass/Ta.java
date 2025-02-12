package org.example.productcatalogservice.tableinheritancerepresentation.tableperclass;

import jakarta.persistence.Entity;

@Entity(name="tpc_ta")
public class Ta extends User {

    String helpRequests;
}
