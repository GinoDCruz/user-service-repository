package com.ibm.userservice.user.repository;

import com.ibm.userservice.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>{

    public User getUserByEmailAddress(String emailAddress);
    public List<User> findUserByEmailAddressIn(List<String> emailAddresses);

}
