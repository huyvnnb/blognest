package com.huyvnnb.blognest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Category extends AbstractEntity<Long> {

    @Column(name = "name")
    @NotNull
    String name;

    @Column(name = "description")
    String description;

    @ManyToMany(mappedBy = "categories")
    Set<Post> posts;
}
