package com.appsdeveloperblogs.app.ws.controller;

import com.appsdeveloperblogs.app.ws.model.response.BaseResponse;
import com.appsdeveloperblogs.app.ws.service.UserService;
import com.appsdeveloperblogs.app.ws.utils.UriConstants;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UriConstants.USER_COLLECTION)
@Tag(name = "User")
@Hidden
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    @Operation(
            description = "Post end point for create User",
            summary = "This is summary of create user endpoint",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Failed",
                            responseCode = "500"
                    )
            }
    )
    public String createUser() {
        return "create user successfully";
    }

    @PutMapping
    public String updateUser() {
        return "create user successfully";
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user successfully";
    }

    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "9") int limit) {

        return "Get Users Page No =" + page + " limit =" + limit;
    }

    @GetMapping(value = "/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(
            description = "Get User By User Id",
            summary = "Get user by user id",
            responses = {
                    @ApiResponse(description = "User found",responseCode = "200"),
                    @ApiResponse(description = "User not found", responseCode = "204")
            }
    )
    public ResponseEntity<BaseResponse> getUser(@PathVariable(name = "userId") String userId) {
        BaseResponse response = userService.getUser(userId);
        log.info("get User Response {} ",response);
        return new ResponseEntity<BaseResponse>(
                response,
                HttpStatus.valueOf(response.getResponseCode()));
    }
}
