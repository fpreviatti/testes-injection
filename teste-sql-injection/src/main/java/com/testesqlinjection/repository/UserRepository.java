package com.testesqlinjection.repository;

import com.testesqlinjection.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<UserInfo,Long> {


    UserInfo findByEmail(String email);



}
