package com.huyvnnb.blognest.service;

import com.huyvnnb.blognest.dto.request.PostCreationRequest;
import com.huyvnnb.blognest.dto.response.PostCreationResponse;
import com.huyvnnb.blognest.dto.response.PostResponse;
import com.huyvnnb.blognest.entity.Category;
import com.huyvnnb.blognest.entity.Post;
import com.huyvnnb.blognest.entity.User;
import com.huyvnnb.blognest.exception.AppException;
import com.huyvnnb.blognest.exception.ErrorCode;
import com.huyvnnb.blognest.mapper.PostMapper;
import com.huyvnnb.blognest.repository.CategoryRepository;
import com.huyvnnb.blognest.repository.PostRepository;
import com.huyvnnb.blognest.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PostService {
    UserRepository userRepository;
    PostRepository postRepository;
    CategoryRepository categoryRepository;
    PostMapper postMapper;

    public PostCreationResponse createPost(PostCreationRequest request){
        Long authorId = request.getAuthorId();

        User user = userRepository.findById(authorId)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        Category category = categoryRepository.findById(request.getCategories())
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_EXIST));

        Post post = postMapper.toPost(request);
        post.setUser(user);
        post.setCategories(category);

        return postMapper.toPostCreationResponse(postRepository.save(post));
    }

    public PostResponse getPostDetail(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new AppException(ErrorCode.POST_NOT_EXISTED));

        PostResponse postResponse = postMapper.toPostResponse(post);


        return postResponse;
    }

    public List<PostResponse> getAll(){

        return postRepository.findAll()
                .stream()
                .map(postMapper::toPostResponse)
                .toList();
    }

    public void delete(Long postId){
        postRepository.deleteById(postId);
    }

}
