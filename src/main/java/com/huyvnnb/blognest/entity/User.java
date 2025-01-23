package com.huyvnnb.blognest.entity;

import com.fasterxml.jackson.databind.annotation.EnumNaming;
import com.huyvnnb.blognest.util.Gender;
import com.huyvnnb.blognest.util.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractEntity<Long> {

    @Column(name = "email", nullable = false, unique = true)
    String email;

    @Column(name = "password", nullable = false)
    String password;

    @Column(name = "nick_name")
    String nickname;

    @Column(name = "first_name", nullable = false)
    String firstName;

    @Column(name = "last_name", nullable = false)
    String lastName;

    @Column(name = "avatar")
    String avatar;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    Gender gender;

    @Column(name = "dob")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    LocalDate dob;

    @Column(name = "enabled")
    Boolean enabled;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    Role role;

    @OneToMany(mappedBy = "user")
    List<Post> post;

    @OneToMany(mappedBy = "user")
    List<Comment> comments;
}