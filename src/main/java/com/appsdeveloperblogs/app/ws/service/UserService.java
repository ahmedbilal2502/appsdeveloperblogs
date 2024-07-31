package com.appsdeveloperblogs.app.ws.service;

import com.appsdeveloperblogs.app.ws.model.response.BaseResponse;
import com.appsdeveloperblogs.app.ws.model.response.UserResponse;
import com.appsdeveloperblogs.app.ws.utils.ApiMatrices;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Scope("prototype")
public class UserService {

    @Autowired
    ApiMatrices apiMatrices;
    List<UserResponse> userResponseList = new ArrayList<>();

    @PostConstruct
    public void init() {
        UserResponse user1 = new UserResponse("1", "John", "Doe", "john.doe@example.com");
        UserResponse user2 = new UserResponse("2", "Jane", "Smith", "jane.smith@example.com");
        userResponseList.add(user1);
        userResponseList.add(user2);
    }

    public BaseResponse getUser(String userId){
        BaseResponse response = new BaseResponse();
        apiMatrices.setStartTime();
        Optional<UserResponse> userResponseOptional = userResponseList
                .stream()
                .filter(userResponse -> userResponse.getUserId().equals(userId)).findFirst();

        if (!userResponseOptional.isPresent()) {
            response.setResponseCode(HttpStatus.NO_CONTENT.value());
            response.setResponseMsg("User not found");
            response.setApiResTime(String.valueOf(apiMatrices.getResponseTime()));
            return response;
        }

        response.setResponseCode(HttpStatus.OK.value());
        response.setResponseMsg("User found");
        response.setApiResTime(String.valueOf(apiMatrices.getResponseTime()));
        response.setData(userResponseOptional.get());
        return response;
    }
    public BaseResponse getUser(){
        BaseResponse response = new BaseResponse();
        if (userResponseList.size() == 0) {
            response.setResponseCode(HttpStatus.NO_CONTENT.value());
            response.setResponseMsg("User not found");
            response.setApiResTime(String.valueOf(apiMatrices.getResponseTime()));
            return response;
        }

        response.setResponseCode(HttpStatus.OK.value());
        response.setResponseMsg("User found");
        response.setApiResTime(String.valueOf(apiMatrices.getResponseTime()));
        response.setData(userResponseList);
        return response;
    }
}
