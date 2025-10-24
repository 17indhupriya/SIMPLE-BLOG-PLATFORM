package com.example.blog.repository;

import com.example.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    // Find posts by status and order by creation date
    List<Post> findByStatusOrderByCreatedAtDesc(Post.PostStatus status);
    
    // Search posts by title or content (case insensitive)
    List<Post> findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(String title, String content);
    
    // Find posts by tags
    List<Post> findByTagsContainingIgnoreCase(String tag);
    
    // Find posts by author
    List<Post> findByAuthorIgnoreCase(String author);
    
    // Custom query to find featured posts (you can customize this logic)
    @Query("SELECT p FROM Post p WHERE p.status = :status AND p.viewCount > 0 ORDER BY p.viewCount DESC")
    List<Post> findFeaturedPosts(@Param("status") Post.PostStatus status);
}
