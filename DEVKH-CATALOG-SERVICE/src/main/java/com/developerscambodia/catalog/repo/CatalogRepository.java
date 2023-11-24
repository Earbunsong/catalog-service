package com.developerscambodia.catalog.repo;

import com.developerscambodia.catalog.entity.Catalog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CatalogRepository extends MongoRepository<Catalog,String> {
    Optional<Catalog> findByUuid(UUID uuid);
}
