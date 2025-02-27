package com.huyvnnb.blognest.dto.response;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostCreationResponse {
    Long id;
    String title;
    String content;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    LocalDateTime createAt;
    String author;
    String categories;
}
