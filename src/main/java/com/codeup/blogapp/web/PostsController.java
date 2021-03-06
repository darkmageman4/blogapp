package com.codeup.blogapp.web;

import com.codeup.blogapp.data.post.Post;
import com.codeup.blogapp.data.post.PostsRepository;
import com.codeup.blogapp.data.user.User;
import com.codeup.blogapp.security.OAuthConfiguration;
import com.codeup.blogapp.services.EmailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostsController {

    private final EmailService emailService;


    private final PostsRepository postsRepository;

    public PostsController(EmailService emailService, PostsRepository postsRepository) {
        this.emailService = emailService;
        this.postsRepository = postsRepository;
    }

    @GetMapping
    public List<Post> getPosts() {return postsRepository.findAll(); }

    @GetMapping("{id}")
    private Post getPostById(@PathVariable Long id) {
        return postsRepository.findById(id).get();
    }

    @GetMapping("/me")
    private User getCurrentUser(OAuthConfiguration auth){
        //        String email = auth.getName();
//       return userRepository.findBYEmail(email).get();
        return null;
    }
    @PostMapping
    private void createPost(@RequestBody Post newPosts, OAuthConfiguration auth) {
//        String email = auth.getName();
//        User user = userRepository.findBYEmail(email).get();
//        newPosts.setUser(user);

        System.out.println(newPosts.getTitle());
        System.out.println(newPosts.getContent());
        postsRepository.save(newPosts);
        emailService.prepareAndSend(newPosts, "test", "the is new post");
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

