package com.codeup.blogapp.web;

import com.codeup.blogapp.data.categories.Category;
import com.codeup.blogapp.data.post.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "api/categories", headers = "Accept=application/json")
public class CategoriesController {

    Collection<Post> userPosts = new ArrayList<>(){{
        add(new Post(1L, "Wagner", "my first", null));
        add(new Post(2L, "Russ", "my middle", null));
        add(new Post(3L, "Charles", "my last", null));
    }};

    @GetMapping
    private Category getPostsByCategory(@RequestParam String categoryName){

        Category categories = new Category(4L, "snowcone");

        categories.setPosts(userPosts);

        System.out.println(categoryName);

        return categories;
    }


}