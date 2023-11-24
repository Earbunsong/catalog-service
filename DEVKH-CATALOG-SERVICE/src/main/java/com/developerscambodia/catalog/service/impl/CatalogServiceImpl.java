package com.developerscambodia.catalog.service.impl;

import com.developerscambodia.catalog.client.CatalogClient;
import com.developerscambodia.catalog.dto.CategoryDto;
import com.developerscambodia.catalog.entity.Catalog;
import com.developerscambodia.catalog.entity.CatalogDto;
import com.developerscambodia.catalog.mapper.CatalogMapper;
import com.developerscambodia.catalog.repo.CatalogRepository;
import com.developerscambodia.catalog.service.CatalogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CatalogServiceImpl implements CatalogService {
    private final CatalogRepository catalogRepository;
    private final CatalogMapper catalogMapper;
    private WebClient webClient;
    private CatalogClient catalogClient;

    @Override
    public List<Catalog> getAllCatalogs() {
        return catalogRepository.findAll();
    }
    @Override
    public List<CategoryDto> findCategoryList() {
        var categoryApi = catalogClient.findCategoryList();
        return categoryApi.data();
    }

    //    @Override
//    public Optional<Catalog> getCatalogById(String id) {
//        return apiClient.findById(id);
//    }
    @Override
    public Catalog createCatalog(Catalog catalog) {
        CatalogDto category = catalogMapper.catalogtoCatalog(catalog);
        String uuid = UUID.randomUUID().toString();
        category.setUuid(uuid);
        return catalogRepository.save(catalog);
    }

    @Override
    public Optional<Catalog> getCatalogByUuid(UUID uuid) {
        return catalogRepository.findByUuid(uuid);
    }

    @Override
    public void updateCatalog(String id, Catalog updatedCatalog) {
        if (catalogRepository.existsById(id)) {
            updatedCatalog.setId(id);
            catalogRepository.save(updatedCatalog);
        }
        // Handle non-existent catalog case if needed
    }

    @Override
    public void deleteCatalog(String id) {
        catalogRepository.deleteById(id);
    }
}
