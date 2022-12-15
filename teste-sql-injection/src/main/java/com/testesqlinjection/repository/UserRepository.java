package com.testesqlinjection.repository;

import com.testesqlinjection.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserInfo,Long> {

    @Query(value = "select * from user_info where email = :email or admin = true" , nativeQuery = true)
    UserInfo findByEmail( @Param("email") String email);

}
