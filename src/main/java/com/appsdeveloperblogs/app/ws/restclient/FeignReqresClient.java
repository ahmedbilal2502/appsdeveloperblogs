package com.appsdeveloperblogs.app.ws.restclient;

import com.appsdeveloperblogs.app.ws.restclient.model.Root;
import com.appsdeveloperblogs.app.ws.restclient.model.usercreate.UserCreateResponse;
import com.appsdeveloperblogs.app.ws.restclient.model.usercreate.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "giveYourServiceName", url = "https://reqres.in/")
public interface FeignReqresClient {
    @GetMapping("api/unknown")
    ResponseEntity<Root> getAllUsers();

    @PostMapping("api/users")
    ResponseEntity<UserCreateResponse> saveNewUsers(@RequestBody Users users);
}
