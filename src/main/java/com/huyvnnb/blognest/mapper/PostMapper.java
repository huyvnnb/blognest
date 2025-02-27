package com.huyvnnb.blognest.mapper;

import com.huyvnnb.blognest.dto.request.PostCreationRequest;
import com.huyvnnb.blognest.dto.response.PostCreationResponse;
import com.huyvnnb.blognest.dto.response.PostResponse;
import com.huyvnnb.blognest.entity.Category;
import com.huyvnnb.blognest.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PostMapper {
    @Mapping(target = "categories", ignore = true)
    Post toPost(PostCreationRequest request);

    @Mapping(target = "author", source = "user.email")
    @Mapping(target = "categories", source = "categories.name")
    PostCreationResponse toPostCreationResponse(Post post);

    @Mapping(target = "author", source = "user.email")
    @Mapping(target = "avatar", source = "user.avatar")
    PostResponse toPostResponse(Post post);



}
