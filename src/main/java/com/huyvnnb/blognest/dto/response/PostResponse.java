package com.huyvnnb.blognest.dto.response;

import com.huyvnnb.blognest.entity.Category;
import com.huyvnnb.blognest.entity.User;
import com.huyvnnb.blognest.repository.UserRepository;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostResponse {
    Long id;
    String author;
    String avatar;
    String title;
    String content;
    LocalDateTime createAt;
    CategoryResponse categories;
}
