package com.Goats.livestock48.controller;

import com.Goats.livestock48.model.User;
import com.Goats.livestock48.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }

    @GetMapping(path = "{userId}")
    public User getUserById(@PathVariable("userId") Long userId){
        return service.getUserById(userId);
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        return service.addUser(user);
    }

    @DeleteMapping(path = "{userId}")
    public User deleteUser(@PathVariable("userId") Long userId){
        return service.deleteUser(userId);
    }

    @PutMapping(path = "{userId}")
    public User updateUsername(@PathVariable("userId") Long userId, @RequestParam(required = true) String username){
        return service.updateUsername(userId, username);
    }
}
