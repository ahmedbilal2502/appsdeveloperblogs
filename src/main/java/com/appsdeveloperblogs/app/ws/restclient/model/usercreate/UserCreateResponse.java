package com.appsdeveloperblogs.app.ws.restclient.model.usercreate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserCreateResponse {
    private String id;
    private String name;
    private String job;
    private LocalDateTime createdAt;
}
