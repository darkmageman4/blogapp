package com.codeup.blogapp.data.post;

import com.codeup.blogapp.data.Post;

import javax.persistence.*;

@Entity
@Table(name="post_images")
public class PostIamge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String path;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
