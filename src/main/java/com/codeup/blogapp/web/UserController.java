package com.codeup.blogapp.web;

import com.codeup.blogapp.data.user.User;
import com.codeup.blogapp.data.user.UserRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json",produces = "application/json")
public class UserController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }


    @PostMapping("/create")
    @PreAuthorize("!hasAuthority('USER')")
    private void createUser(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @PutMapping("{id}")
    private void updateUser(@PathVariable Long id, @RequestBody User user){
        System.out.println(user.getPassword());
        System.out.println(user.getEmail());
        System.out.println(user.getUsername());
        System.out.println(user.getId());
        userRepository.save(user);
    }

    @DeleteMapping("{id}")
    private void deleteUser(@PathVariable Long id){
        System.out.println("Deleting user with id " + id);
       userRepository.deleteById(id);
    }

    @GetMapping("{id}")
    private User findById(@PathVariable Long id){
      return userRepository.getById(id);
    }

    @GetMapping("/findByUsername")
    private Optional<User> findByUsername(@RequestParam String username){
return userRepository.findByUsername(username);
    }

    @GetMapping("/findByEmail")
    private User findByEmail(@RequestParam String email){
        return userRepository.findByEmail(email).get();
    }

    @PutMapping ("{id}/updatePassword")
    private void updatePassword(@PathVariable Long id, @RequestParam(required = false) String oldPassword, @Valid @Size(min = 3) @RequestParam String newPassword){
    }



}
