package com.appsdeveloperblogs.app.ws;

import com.appsdeveloperblogs.app.ws.entity.User;
import com.appsdeveloperblogs.app.ws.repository.UserRepository;
import com.appsdeveloperblogs.app.ws.restclient.FeignReqresClient;
import com.appsdeveloperblogs.app.ws.restclient.RestClientService;
import com.appsdeveloperblogs.app.ws.restclient.model.usercreate.Users;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@AllArgsConstructor
@Slf4j
@EnableFeignClients
public class MobileAppWsApplication {

    private final UserRepository userRepository;
    private final RestClientService restClientService;
    private final FeignReqresClient feignReqresClient;


    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(MobileAppWsApplication.class, args);
        ConfigurableEnvironment configurableEnvironment = context.getEnvironment();
        log.error(" {} ", configurableEnvironment);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            log.info("Get User Count is :: {} ", restClientService.getAllUsers());
            log.info("New User Create   :: {} ", restClientService.saveNewUsers(new Users("Ahmed", "leader")));

            log.info("Feign Client :: {} ", feignReqresClient.getAllUsers().getBody());
            log.info("New User Create Feign  :: {} ", feignReqresClient.saveNewUsers(new Users("Ahmed Bilal", "leader")));

            var admin = User.builder().firstname("Admin").lastname("Admin").email("admin@mail.com").password("password").userName("username").build();

            userRepository.save(admin);


            System.out.println(userRepository.findByEmail("admin@mail.com").get().getPassword());
        };
    }
}
