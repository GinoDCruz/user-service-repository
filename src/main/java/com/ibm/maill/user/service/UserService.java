package com.ibm.maill.user.service;

import com.ibm.maill.user.entity.User;
import com.ibm.maill.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserService {

    private final HashMap<Long, User> hashMap = new HashMap<>();
    private UserRepository repository;

    @Autowired
    public void setRepository(UserRepository repository){
        this.repository = repository;
    }

    public User createUser(User user){
        user.setId(1L);

        return repository.save(user);
    }

    public User getUser(Long id){
        return repository.findById(id).get();
    }

    public User updateUser(User user){
        return repository.save(user);
    }

    public Iterable<User> deleteUser(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
        return repository.findAll();
    }
}
