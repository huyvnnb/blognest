package com.huyvnnb.blognest.mapper;

import com.huyvnnb.blognest.dto.request.CategoryCreationRequest;
import com.huyvnnb.blognest.dto.response.CategoryResponse;
import com.huyvnnb.blognest.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toCategory(CategoryCreationRequest request);
    CategoryResponse toCategoryResponse(Category category);
}
