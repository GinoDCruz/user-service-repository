package com.ibm.userservice.user.repository;

import com.ibm.userservice.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

}