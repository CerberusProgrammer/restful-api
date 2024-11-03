package com.example.restful_api.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    final UserService userService;

    @GetMapping
    public List<User> findAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        UserQueryParams params = new UserQueryParams();
        params.setName(name);
        params.setEmail(email);
        return userService.findAll(params);
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }
}