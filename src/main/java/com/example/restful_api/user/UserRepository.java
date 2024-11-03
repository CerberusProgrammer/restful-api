package com.example.restful_api.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

@Service
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

}
