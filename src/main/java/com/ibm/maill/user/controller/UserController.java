package com.ibm.maill.user.controller;

import com.ibm.maill.user.entity.User;
import com.ibm.maill.user.service.UserService;
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
        return new User(1L,"testusername", "testpassword", "testfistname", "testlastname");
    }

    @GetMapping("/get/{id}")
    public User getUser(@RequestParam long id){
        //Another step to retrieve user

        return userService.getUser(id);
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Long id){
        return userService.updateUser(id);
    }

    @DeleteMapping("/delete/{id}")
    public User deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }

}
