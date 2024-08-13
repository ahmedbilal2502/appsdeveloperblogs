package com.appsdeveloperblogs.app.ws.restclient;

import com.appsdeveloperblogs.app.ws.entity.User;
import com.appsdeveloperblogs.app.ws.restclient.model.Root;
import com.appsdeveloperblogs.app.ws.restclient.model.usercreate.UserCreateResponse;
import com.appsdeveloperblogs.app.ws.restclient.model.usercreate.Users;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.*;

@Service
@AllArgsConstructor
public class RestClientService {

    private final RestClient restClient;

    public RestClientService(){
        restClient = RestClient.builder()
                .baseUrl("https://reqres.in/")
                .build();
    }
    public Root getAllUsers(){
        return restClient.get()
                .uri("api/users?page=2")
                .retrieve()
                .body(Root.class);
    }

    public UserCreateResponse saveNewUsers(Users users) {
        return restClient.post()
                .uri("api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .body(users)
                .retrieve()
                .body(UserCreateResponse.class);
    }

}
