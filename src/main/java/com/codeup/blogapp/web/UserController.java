package com.codeup.blogapp.web;

import com.codeup.blogapp.data.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UserController {

    @GetMapping
    public List<User> getUsers() {

        User user = new User(1L, "Wagner", "wag@codeup.com", "password", User.Role.ADMIN);

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

//    @GetMapping("{id}")
//    private User findById(@PathVariable Long id){
////        return getUsers().stream()
////                .filter(t -> id.equals(t.getId())).findFirst().orElse(null);
//        System.out.println(id);
//        return null;
//    }

    @GetMapping("/findByUsername")
    private User findByUsername(@PathVariable String username){
//        return getUsers().stream()
//                .filter(t -> username.equals(t.getUsername())).findFirst().orElse(null);
        System.out.println(username);
        return null;
    }

    @GetMapping("/findByEmail")
    private User findByEmail(@RequestParam String email){
//        return getUsers().stream()
//                .filter(t -> email.equals(t.getEmail())).findFirst().orElse(null);
        System.out.println(email);
        return null;


    }

    @GetMapping("{id}/updatePassword")
    private void updatePassword(@PathVariable Long id, @RequestParam(required = false) String oldPassword, @Valid @Size(min = 3) @RequestParam String newPassword
    ){

    }

}
