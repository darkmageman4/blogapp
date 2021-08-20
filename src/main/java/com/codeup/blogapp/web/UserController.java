package com.codeup.blogapp.web;

import com.codeup.blogapp.data.user.User;
import com.codeup.blogapp.data.user.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getUsers() {

//        User user = new User(1L, "Wagner", "wag@codeup.com", "password",null);
//
//        return new ArrayList<>() {{
//            add(new User(1L, "Wagner", "wag@codeup.com", "password", null));
//                    add(new User(2L, "Russ", "rus@codeup.com", "password", null));
//                    add(new User(3L, "Charles", "char@codeup.com", "password", null));
//        }};

        return userRepository.findAll();

    }

    @GetMapping("{id}")
private User getUserById(@PathVariable Long id){
//        if (id == 1) {
//            return new User(1L, "Wagner", "wag@codeup.com", "password", null);
//        }else{
//            return null;
//        }

        return userRepository.getById(id);
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
        userRepository.save(user);
    }

    @DeleteMapping
    private void deleteUser(@PathVariable Long id){
        System.out.println("Deleting user with id " + getUserById(id));
       userRepository.deleteById(id);
    }

    @GetMapping("{id}")
    private User findById(@PathVariable Long id){
       userRepository.findById(id);
    }

    @GetMapping("/findByUsername")
    private User findByUsername(@PathVariable String username){
return userRepository.findByUsername(username);
    }

    @GetMapping("/findByEmail")
    private User findByEmail(@RequestParam String email){
        return userRepository.findByEmail(email);
    }

    @GetMapping("{id}/updatePassword")
    private void updatePassword(@PathVariable Long id, @RequestParam(required = false) String oldPassword, @Valid @Size(min = 3) @RequestParam String newPassword
    ){

    }

}
