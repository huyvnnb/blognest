package com.huyvnnb.blognest.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Filter;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostCreationRequest {
    @NotBlank(message = "TITLE_INVALID")
    String title;
    @NotBlank(message = "CONTENT_INVALID")
    String content;
    Long authorId;
    Long categories;
}
