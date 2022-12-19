package com.testesqlinjection.repository;

import com.testesqlinjection.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserInfo,Long> {

    @Query(value = "select * from user_info where email = :email and senha =CONCAT(:senha, '')" , nativeQuery = true)
    UserInfo findByEmailAndSenha( @Param("email") String email, @Param("senha") String senha);

    UserInfo findByEmail(String email);
}
