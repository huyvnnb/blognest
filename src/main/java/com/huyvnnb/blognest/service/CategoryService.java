package com.huyvnnb.blognest.service;

import com.huyvnnb.blognest.dto.request.CategoryCreationRequest;
import com.huyvnnb.blognest.dto.response.CategoryResponse;
import com.huyvnnb.blognest.entity.Category;
import com.huyvnnb.blognest.exception.AppException;
import com.huyvnnb.blognest.exception.ErrorCode;
import com.huyvnnb.blognest.mapper.CategoryMapper;
import com.huyvnnb.blognest.repository.CategoryRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryService {
    CategoryRepository categoryRepository;
    CategoryMapper categoryMapper;

    public CategoryResponse createCategory(CategoryCreationRequest request){
        if(categoryRepository.findByName(request.getName()).isPresent()){
            throw new AppException(ErrorCode.CATEGORY_EXISTED);
        }
        Category category = categoryMapper.toCategory(request);
        return categoryMapper.toCategoryResponse(categoryRepository.save(category));
    }

    public List<CategoryResponse> getCategories(){
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toCategoryResponse)
                .toList();
    }
}
