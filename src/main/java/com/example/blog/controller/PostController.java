package com.example.blog.controller;

import com.example.blog.model.Post;
import com.example.blog.repository.PostRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/")
    public String listPosts(Model model, @RequestParam(value = "search", required = false) String search) {
        if (search != null && !search.trim().isEmpty()) {
            model.addAttribute("posts", postRepository.findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(search, search));
            model.addAttribute("searchTerm", search);
        } else {
            model.addAttribute("posts", postRepository.findByStatusOrderByCreatedAtDesc(Post.PostStatus.PUBLISHED));
        }
        return "index";
    }

    @GetMapping("/posts/new")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "create_post";
    }

    @PostMapping("/posts")
    public String savePost(@Valid @ModelAttribute("post") Post post, BindingResult result, 
                          Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "create_post";
        }
        postRepository.save(post);
        redirectAttributes.addFlashAttribute("successMessage", "Post created successfully!");
        return "redirect:/";
    }

    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable Long id, Model model) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            Post foundPost = post.get();
            foundPost.incrementViewCount();
            postRepository.save(foundPost);
            model.addAttribute("post", foundPost);
            return "view_post";
        }
        return "redirect:/";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            model.addAttribute("post", post.get());
            return "edit_post";
        }
        return "redirect:/";
    }

    @PostMapping("/posts/{id}")
    public String updatePost(@PathVariable Long id, @Valid @ModelAttribute("post") Post post, 
                           BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            post.setId(id);
            return "edit_post";
        }
        post.setId(id);
        postRepository.save(post);
        redirectAttributes.addFlashAttribute("successMessage", "Post updated successfully!");
        return "redirect:/posts/" + id;
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        postRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("successMessage", "Post deleted successfully!");
        return "redirect:/";
    }
}
