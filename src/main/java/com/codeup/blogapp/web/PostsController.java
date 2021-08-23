package com.codeup.blogapp.web;

import com.codeup.blogapp.data.post.Post;
import com.codeup.blogapp.data.post.PostsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostsController {

    private final PostsRepository postsRepository;

    public PostsController(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    @GetMapping
    public List<Post> getPosts() {return postsRepository.findAll(); }

    @GetMapping("{id}")
    private Post getPostById(@PathVariable Long id) {
//        return postsRepository.getById(id);
        return postsRepository.findById(id).get();
    }

    @PostMapping
    private void createPost(@RequestBody Post newPosts) {
        System.out.println(newPosts.getTitle());
        System.out.println(newPosts.getContent());
        postsRepository.save(newPosts);
    }

    @PutMapping("{/{id}}")
    private void updatePost(@PathVariable Long id, @RequestBody Post postToUpdate) {
        System.out.println(postToUpdate.getContent());
        System.out.println("Updating post with id: " + id);
        System.out.println(postToUpdate);
        postsRepository.save(postToUpdate);
    }


    @DeleteMapping("{id}")
    private void deletePost(@PathVariable Long id) {
        System.out.println("Delete post with id: " + id);
        postsRepository.deleteById(id);
    }


}

