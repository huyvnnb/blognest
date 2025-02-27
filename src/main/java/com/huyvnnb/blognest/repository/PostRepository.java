package com.huyvnnb.blognest.repository;

import com.huyvnnb.blognest.dto.response.PostResponse;
import com.huyvnnb.blognest.entity.Category;
import com.huyvnnb.blognest.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
//    @Query("SELECT p FROM Post p JOIN FETCH p.categories c JOIN FETCH p.user WHERE p.id = :postId")
//    Optional<Post> findPostWithCategoriesAndUser(@Param("postId") Long postId);
}
