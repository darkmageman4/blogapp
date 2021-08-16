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
            add(new Post(1L, "Harry Potter", "A wizard doing stuff"));
            add(new Post(2L, "Spider-man", "A spiderman turned into a man"));
            add(new Post(3L, "Aqua-lad", "Half fish Half lamp"));
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

