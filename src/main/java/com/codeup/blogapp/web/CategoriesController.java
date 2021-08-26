package com.codeup.blogapp.web;

import com.codeup.blogapp.data.categories.CategoriesRepository;
import com.codeup.blogapp.data.categories.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/categories", headers = "Accept=application/json")
public class CategoriesController {

    private final CategoriesRepository categories;

    public CategoriesController(CategoriesRepository categories) {
        this.categories = categories;
    }

    @GetMapping
    private List<Category> getCategory(){

        return categories.findAll();
    }


}