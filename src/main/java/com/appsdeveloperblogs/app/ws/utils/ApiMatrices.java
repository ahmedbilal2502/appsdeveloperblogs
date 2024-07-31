package com.appsdeveloperblogs.app.ws.utils;

import org.springframework.stereotype.Component;

@Component
public class ApiMatrices {
    private long startTime;

    public void setStartTime() {
        startTime = System.currentTimeMillis();
    }

    public long getResponseTime() {
        return System.currentTimeMillis() - startTime;
    }

}