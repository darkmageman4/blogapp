package com.codeup.blogapp.data.user;

import com.codeup.blogapp.data.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query
    User findByEmail(String email);

    @Query
    User findByUsername(String username);
}
