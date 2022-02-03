package com.ibm.userservice.user.controller;

import com.ibm.userservice.user.entity.User;
import com.ibm.userservice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/create-sample")
    public User hello(){
        return userService.createUser(new User(1L,"testusername", "testpassword", "testfistname", "testlastname"));
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

    @GetMapping("/getAll")
    public Iterable<User> getAll(){
        return userService.getUsers();
    }

}
