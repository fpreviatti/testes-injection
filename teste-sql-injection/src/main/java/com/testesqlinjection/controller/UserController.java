package com.testesqlinjection.controller;

import com.testesqlinjection.model.UserInfo;
import com.testesqlinjection.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/users")
    public ResponseEntity<List<UserInfo>> findAll(){

        List<UserInfo> users = userService.getUsers();
        return ResponseEntity.ok().body(users);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<UserInfo> findByEmail(@RequestBody UserInfo usuario) {

        UserInfo user = userService.getByEmail(usuario.getEmail());

        if(user!=null && user.getSenha().equals(usuario.getSenha())){
            System.out.println("email" +user.getEmail());
            System.out.println("senha" +user.getSenha());

            return ResponseEntity.ok().body(user);
        }

        else{
            return ResponseEntity.notFound().build();
        }



    }

}
