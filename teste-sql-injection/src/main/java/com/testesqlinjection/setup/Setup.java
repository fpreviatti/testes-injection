package com.testesqlinjection.setup;

import com.testesqlinjection.model.UserInfo;
import com.testesqlinjection.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Setup implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {

        UserInfo user1 = new UserInfo();

        user1.setEmail("abubleh@abublau.com");
        user1.setSenha("123456");
        user1.setAdmin(true);

        UserInfo user2 = new UserInfo();
        user2.setEmail("blablublei@okokokok.com");
        user2.setSenha("123456");
        user2.setAdmin(false);

        userService.save(user1);
        userService.save(user2);

    }

}