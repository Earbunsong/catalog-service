package com.developerscambodia.catalog.response;

import com.developerscambodia.catalog.dto.CategoryDto;
import com.developerscambodia.catalog.entity.CatalogDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private CatalogDto catalogDto;
    private CategoryDto categoryDto;
}
