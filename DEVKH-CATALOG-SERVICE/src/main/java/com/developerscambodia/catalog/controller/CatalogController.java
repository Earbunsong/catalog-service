package com.developerscambodia.catalog.controller;

import com.developerscambodia.catalog.dto.CategoryDto;
import com.developerscambodia.catalog.entity.Catalog;
import com.developerscambodia.catalog.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/catalogs")
@RequiredArgsConstructor
public class CatalogController {
    private final CatalogService catalogService;

    @GetMapping
    public List<Catalog> getAllCatalogs() {
        return catalogService.getAllCatalogs();
    }

    @GetMapping("/categories")
    public List<CategoryDto> findCategoryList() {
        System.out.println("Hello");
        return catalogService.findCategoryList();
    }

    @PostMapping
    public Catalog createCatalog(@RequestBody Catalog catalog) {
        return catalogService.createCatalog(catalog);
    }
    @GetMapping("/uuid/{uuid}")
    public Optional<Catalog> getCatalogByUuid(@PathVariable UUID uuid) {
        return catalogService.getCatalogByUuid(uuid);
    }

    @PutMapping("/{id}")
    public void updateCatalog(@PathVariable String id, @RequestBody Catalog updatedCatalog) {
        catalogService.updateCatalog(id, updatedCatalog);
    }
    @DeleteMapping("/{id}")
    public void deleteCatalog(@PathVariable String id) {
        catalogService.deleteCatalog(id);
    }
}
