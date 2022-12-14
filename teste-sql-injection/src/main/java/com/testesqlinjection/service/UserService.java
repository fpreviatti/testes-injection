package com.testesqlinjection.service;

import com.testesqlinjection.model.UserInfo;
import com.testesqlinjection.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserInfo> getUsers(){
        return userRepository.findAll();
    }

    public UserInfo getByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public void save(UserInfo user){
        userRepository.save(user);
    }

}
