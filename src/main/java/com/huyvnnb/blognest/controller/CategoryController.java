package com.huyvnnb.blognest.controller;

import com.huyvnnb.blognest.dto.request.CategoryCreationRequest;
import com.huyvnnb.blognest.dto.response.ApiResponse;
import com.huyvnnb.blognest.dto.response.CategoryResponse;
import com.huyvnnb.blognest.entity.Category;
import com.huyvnnb.blognest.service.CategoryService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/api/v1/category")
public class CategoryController {
    CategoryService categoryService;

    @PostMapping("/create")
    public ApiResponse<CategoryResponse> createCategory(@RequestBody @Valid CategoryCreationRequest request){
        return ApiResponse.<CategoryResponse>builder()
                .result(categoryService.createCategory(request))
                .build();
    }

    @GetMapping("/all")
    public ApiResponse<List<CategoryResponse>> getCategories(){
        return ApiResponse.<List<CategoryResponse>>builder()
                .result(categoryService.getCategories())
                .build();
    }
}
