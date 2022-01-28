package com.ibm.maill.user.repository;

import com.ibm.maill.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

}
