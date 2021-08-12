package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Post;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostsController {


    @GetMapping
    public List<Post> getPosts() {

        return new ArrayList<Post>() {{
            add(new Post(1L, "A new Post", "I rate it 10 out of 10"));
            add(new Post(2L, "A new Post", "I rate it 11 out of 10"));
            add(new Post(3L, "A new Post", "I rate it 12 out of 10"));
        }};

    }

    @GetMapping("{id}")
    private Post getPostById(@PathVariable Long id) {
        if (id == 1) {
            return new Post(1L, "A new Post", "I rate it 10 out of 10");
        } else {
            return null;
        }
    }

    @PostMapping
    private void createPost(@RequestBody Post obj){
        System.out.println(obj.getTitle());
        System.out.println(obj.getContent());
        System.out.println(obj.getId());
    }

    @PutMapping("{/{id}}")
    private void updatePost(@PathVariable Long id, @RequestBody Post post){
        System.out.println(post.getContent());
    }

    @DeleteMapping("{id}")
    private void deletePost(@PathVariable Long id){
        System.out.println();
    }


}

