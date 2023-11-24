package com.developerscambodia.catalog.mapper;

import com.developerscambodia.catalog.entity.Catalog;
import com.developerscambodia.catalog.entity.CatalogDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CatalogMapper {
    CatalogDto catalogtoCatalog(Catalog catalog);
}
