package com.ibm.userservice.user.service;

import com.ibm.userservice.user.entity.LoginForm;
import com.ibm.userservice.user.entity.Session;
import com.ibm.userservice.user.entity.User;
import com.ibm.userservice.user.repository.SessionRepository;
import com.ibm.userservice.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private SessionRepository sessionRepository;

    @Autowired
    public void setRepositories(UserRepository userRepository, SessionRepository sessionRepository){
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
    }

    public User createUser(User user){
        long leftLimit = 1L;
        long rightLimit = 10L;
        long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
        user.setUser_id(generatedLong);

        return userRepository.save(user);
    }

    public Iterable<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUser(Long id){
        return userRepository.findById(id).get();
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }

    public Iterable<User> deleteUser(Long id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
        }
        return userRepository.findAll();
    }

    public User getUserByEmail(String emailAddress){
        return userRepository.getUserByEmailAddress(emailAddress);
    }

    public Iterable<User> getUsersByEmailAddresses(List<String> emailAddresses) {
        return userRepository.findUserByEmailAddressIn(emailAddresses);
    }

    public Session loginUser(LoginForm user){
       if(userRepository.getUserByEmailAddress(user.getEmailAddress()).getPassword().equals(user.getPassword())){
            Session session = new Session(10L,userRepository.getUserByEmailAddress(user.getEmailAddress()),true);
            System.out.println(session.getSession_id());
            return sessionRepository.save(session);
       }
       return null;
    }

    public Session logoutUser(LoginForm user){
        if(userRepository.getUserByEmailAddress(user.getEmailAddress()).getPassword().equals(user.getPassword())){
            Session session = new Session(10L,userRepository.getUserByEmailAddress(user.getEmailAddress()),false);
            return sessionRepository.save(session);
        }
        return null;
    }
}
