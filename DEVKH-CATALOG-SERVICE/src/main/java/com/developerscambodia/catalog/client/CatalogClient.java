package com.developerscambodia.catalog.client;

import com.developerscambodia.catalog.dto.ApiDto;
import com.developerscambodia.catalog.dto.CategoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient (value = "COURSE-SERVICE", url = "http://localhost:8086/api/v1/categories")
public interface CatalogClient {
    @GetMapping("/{uuid}")
    ApiDto<CategoryDto> findCategoryByUuid(@PathVariable String uuid);
    @GetMapping
    ApiDto<List<CategoryDto>> findCategoryList();

}
