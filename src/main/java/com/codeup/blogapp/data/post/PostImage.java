//package com.codeup.blogapp.data.post;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name="post_images")
//public class PostImage {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false)
//    private String path;
//
//    @ManyToOne
//    @JoinColumn(name = "post_id")
//    private Post post;
//
//    public PostImage(Long id, String path, Post post) {
//        this.id = id;
//        this.path = path;
//        this.post = post;
//    }
//
//    public PostImage(){}
//}
