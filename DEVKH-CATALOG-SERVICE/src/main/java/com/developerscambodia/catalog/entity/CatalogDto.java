package com.developerscambodia.catalog.entity;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CatalogDto {
    private String uuid;
    private String name;
    private String description;
}
