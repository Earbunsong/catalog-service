package com.developerscambodia.catalog.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "catalogs")
public class Catalog {
    @Id
    private String id;
    private String uuid;
    private String name;
}
