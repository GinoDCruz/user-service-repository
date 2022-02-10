package com.ibm.userservice.user.repository;


import com.ibm.userservice.user.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session,Long> {
}
