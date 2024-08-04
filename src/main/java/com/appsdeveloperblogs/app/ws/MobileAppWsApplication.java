package com.appsdeveloperblogs.app.ws;

import com.appsdeveloperblogs.app.ws.entity.User;
import com.appsdeveloperblogs.app.ws.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@Slf4j
public class MobileAppWsApplication {
    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {

        ConfigurableApplicationContext context= SpringApplication.run(MobileAppWsApplication.class, args);
        ConfigurableEnvironment configurableEnvironment=context.getEnvironment();
        log.error(" {} ",configurableEnvironment);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            var admin = User.builder().firstname("Admin").lastname("Admin").email("admin@mail.com").password("password").userName("username").build();

            userRepository.save(admin);


            System.out.println(userRepository.findByEmail("admin@mail.com").get().getPassword());
        };
    }
}
