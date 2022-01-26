package com.ibm.maill.user.service;

import com.ibm.maill.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserService {

    /*
    public User createUser(Long id,String username, String password, String firstname, String lastname){
        return new User(id, username,password,firstname,lastname);
    }
    */

    private final HashMap<Long, User> hashMap = new HashMap<>();

    public User createUser(User user){
        //Replace with random ID generator
        long id = 10L;

        hashMap.put(id, user);

        return hashMap.get(id);
    }

    public User getUser(Long id){
        return hashMap.get(id);
    }

    public User updateUser(Long id){
        //hashMap.put(id, user);

        return hashMap.get(id);
    }

    public User deleteUser(Long id){
        hashMap.remove(id);

        return hashMap.get(id);
    }
}
