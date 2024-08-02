package com.appsdeveloperblogs.app.ws;

import com.appsdeveloperblogs.app.ws.entity.User;
import com.appsdeveloperblogs.app.ws.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MobileAppWsApplication {
    @Autowired
    UserRepository userRepository;
    public static void main(String[] args) {
        SpringApplication.run(MobileAppWsApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(

    ) {
        return args -> {
            var admin = User.builder()
                    .firstname("Admin")
                    .lastname("Admin")
                    .email("admin@mail.com")
                    .password("password")
                    .userName("username")
                    .build();
            userRepository.save(admin);

        };
    }
}
