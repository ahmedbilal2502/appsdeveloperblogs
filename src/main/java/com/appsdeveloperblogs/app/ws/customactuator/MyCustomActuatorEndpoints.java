package com.appsdeveloperblogs.app.ws.customactuator;

import com.appsdeveloperblogs.app.ws.model.response.BaseResponse;
import com.appsdeveloperblogs.app.ws.service.UserService;
import com.appsdeveloperblogs.app.ws.utils.ApiMatrices;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Endpoint(id="customactuator")
@Component
public class MyCustomActuatorEndpoints {

    private final UserService userService;

    private final ApiMatrices apiMatrices;

    public MyCustomActuatorEndpoints(UserService userService, ApiMatrices apiMatrices){
        this.userService=userService;
        this.apiMatrices = apiMatrices;
    }
    @ReadOperation
    @Bean
    public BaseResponse getCustomActuatorExample() {
       return userService.getUser();
    }
}
