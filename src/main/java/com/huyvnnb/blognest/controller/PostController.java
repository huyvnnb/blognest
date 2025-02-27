package com.huyvnnb.blognest.controller;

import com.huyvnnb.blognest.dto.request.PostCreationRequest;
import com.huyvnnb.blognest.dto.response.ApiResponse;
import com.huyvnnb.blognest.dto.response.PostCreationResponse;
import com.huyvnnb.blognest.dto.response.PostResponse;
import com.huyvnnb.blognest.service.PostService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/api/v1/post")
public class PostController {
    PostService postService;
    @PostMapping("/create")
    public ApiResponse<PostCreationResponse> createPost(@RequestBody @Valid PostCreationRequest request){
        return ApiResponse.<PostCreationResponse>builder()
                .code(HttpStatus.CREATED.value())
                .result(postService.createPost(request))
                .build();
    }

    @GetMapping("/{postId}")
    public ApiResponse<PostResponse> getPostDetail(@PathVariable Long postId){
        return ApiResponse.<PostResponse>builder()
                .result(postService.getPostDetail(postId))
                .build();
    }

    @GetMapping("/all")
    public ApiResponse<List<PostResponse>> getAll(){
        return ApiResponse.<List<PostResponse>>builder()
                .code(HttpStatus.CREATED.value())
                .result(postService.getAll())
                .build();
    }

    @DeleteMapping("/delete/{postId}")
    public ApiResponse<Void> delete(@PathVariable Long postId){
        postService.delete(postId);
        return ApiResponse.<Void>builder()
                .build();
    }
}
