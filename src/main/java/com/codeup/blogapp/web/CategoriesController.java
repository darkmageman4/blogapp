package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Category;
import com.codeup.blogapp.data.Post;
import com.codeup.blogapp.data.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/api/categories", headers = "Accept=applications/json")
public class CategoriesController {

    List<Post> posts= new ArrayList<Post>() {{
        add(new Post(1L, "Harry Potter", "A wizard doing stuff"));
        add(new Post(2L, "Spider-man", "A spiderman turned into a man"));
        add(new Post(3L, "Aqua-lad", "Half fish Half lamp"));
    }};

    @GetMapping
    public List<Category> getCategories() {
        return new ArrayList<Category>() {{
            add(new Category(1L, "Wagner"));
            add(new Category(2L, "Russ"));
            add(new Category(3L, "Charles"));
        }};

    }

//    @GetMapping
//    private List<Category> getPostsByCategory() {
//        return new ArrayList<Category>() {{
//            add(new Category(1L, "Wagner", null));
//            add(new Category(2L, "Russ", null));
//            add(new Category(3L, "Charles", null));
//        }};
//    }

           @GetMapping ("/{id}")
    private Category getCategoriesById(@PathVariable Long id){

        Category category = new Category(1L, "Wagner");

        category.setPosts(posts);

        return category;
    }


}
