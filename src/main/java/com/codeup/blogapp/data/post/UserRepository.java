package com.codeup.blogapp.data.post;

import com.codeup.blogapp.data.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Post, Long> {
}
