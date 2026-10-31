package com.travel.userservice.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.travel.userservice.entity.User;
import com.travel.userservice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) { this.userService = userService; }

    @PostMapping
    public User saveUser(@RequestBody User user) { return userService.saveUser(user); }
    @GetMapping
    public List<User> getAllUsers() { return userService.getAllUsers(); }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) { return userService.getUserById(id); }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) { return userService.updateUser(id, user); }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) { userService.deleteUser(id); return "User deleted successfully"; }
}
