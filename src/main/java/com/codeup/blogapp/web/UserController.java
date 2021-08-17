package com.codeup.blogapp.web;

import com.codeup.blogapp.data.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UserController {

    @GetMapping
    public List<User> getUsers() {

        return new ArrayList<>() {{
            add(new User(1L, "Wagner", "wag@codeup.com", "password", User.Role.ADMIN));
                    add(new User(2L, "Russ", "rus@codeup.com", "password", User.Role.USER));
                    add(new User(3L, "Charles", "char@codeup.com", "password", User.Role.USER));
        }};
    }

    @GetMapping("{id}")
private User getUserById(@PathVariable Long id){
        if (id == 1) {
            return new User(1L, "Wagner", "wag@codeup.com", "password", User.Role.USER);
        }else{
            return null;
        }
    }

    @PostMapping
    private void createUser(@RequestBody User obj){
        System.out.println(obj.getEmail());
        System.out.println(obj.getUsername());
        System.out.println(obj.getPassword());
    }

    @PutMapping("{id}")
    private void updateUser(@PathVariable Long id, @RequestBody User user){
        System.out.println(user.getPassword());
        System.out.println(user.getEmail());
        System.out.println(user.getUsername());
        System.out.println(user.getId());
    }

    @DeleteMapping
    private void deleteUser(@PathVariable Long id){
        System.out.println("Deleting user with id " + getUserById(id));
    }

}
