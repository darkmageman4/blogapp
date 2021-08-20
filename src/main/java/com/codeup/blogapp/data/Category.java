package com.codeup.blogapp.data;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "categories")
    private Collection<Post> posts;

    @ManyToMany(mappedBy = "categories")
    private List<Post> posts;

    public Category() {}


    public Collection<Post> getPosts() {
        return posts;
    }

    public void setPosts(Collection<Post> posts) {
        this.posts = posts;
    }

    public Category(Collection<Post> posts, String name) {
        this.posts = posts;
        this.name = name;
    }

    public Category(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}