package com.developerscambodia.catalog.service;

import com.developerscambodia.catalog.dto.CategoryDto;
import com.developerscambodia.catalog.dto.CourseDto;
import com.developerscambodia.catalog.entity.Catalog;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CatalogService {
    List<Catalog> getAllCatalogs();
    List<CategoryDto> findCategoryList();
    Catalog createCatalog(Catalog catalog);
    Optional<Catalog> getCatalogByUuid(UUID uuid);
    void updateCatalog(String id, Catalog updatedCatalog);
    void deleteCatalog(String id);
//    CourseDto findListCourse()
}
