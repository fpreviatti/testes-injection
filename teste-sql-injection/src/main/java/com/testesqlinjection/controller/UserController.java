package com.testesqlinjection.controller;

import com.testesqlinjection.SecurityConfig;
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
    public ResponseEntity<UserInfo> login(@RequestBody UserInfo usuario) {

        UserInfo user = userService.getByEmailAndSenha(usuario.getEmail(), usuario.getSenha());

        if (user != null) {
                return ResponseEntity.ok().body(user);

        }

            return ResponseEntity.notFound().build();

    }

    @PostMapping(value = "/cadastro")
    public ResponseEntity<UserInfo> cadastro(@RequestBody UserInfo usuario) {

        UserInfo user = userService.getByEmail(usuario.getEmail());

        if (user != null) {

            System.out.println("Usuario ja cadastrado");

            return null;

        }


        SecurityConfig securityConfig = new SecurityConfig();

        String senhaEncode = securityConfig.cifrador().encode(usuario.getSenha());
        usuario.setSenha(senhaEncode);

        userService.save(usuario);

        return ResponseEntity.ok().body(usuario);

    }

}
