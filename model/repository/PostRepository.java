package com.example.blog.repository;

import com.example.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    // This interface is intentionally left blank.
    // Spring Data JPA will automatically create all the necessary methods
    // for saving, finding, and deleting posts based on the JpaRepository.
}