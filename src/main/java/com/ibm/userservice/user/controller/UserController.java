package com.ibm.userservice.user.controller;

import com.ibm.userservice.user.entity.LoginForm;
import com.ibm.userservice.user.entity.Session;
import com.ibm.userservice.user.entity.User;
import com.ibm.userservice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/login")
    public Session login(@RequestBody LoginForm loginForm){
        return userService.loginUser(loginForm);
    }

    @PostMapping("/logout")
    public Session logout(@RequestBody LoginForm loginForm){
        return userService.logoutUser(loginForm);
    }

    @GetMapping("/get/{id}")
    public User getUser(@PathVariable("id") Long id){
        return userService.getUser(id);
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping("/update/{id}")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public Iterable<User> deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }

    @GetMapping("/get/all")
    public Iterable<User> getAll(){
        return userService.getUsers();
    }

    @GetMapping("/get/email")
    public User getUserByEmail(@RequestParam String emailAddress){
        return userService.getUserByEmail(emailAddress);
    }

    @GetMapping("/get/emails")
    public Iterable<User> getUsersByEmails(@RequestParam List<String> emailAddresses){
        return userService.getUsersByEmailAddresses(emailAddresses);
    }

}
