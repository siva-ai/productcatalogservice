package org.example.productcatalogservice.productmodels;

import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@MappedSuperclass  // used when there is abstract class which is extended by every table does not need separate class but will be part of tables
public abstract class BaseModel {
    @Id
    private Long id;
    private Date createdAt;
    private Date lastUpdatedAt;
    @Enumerated
    private State state;
}
