package com.appsdeveloperblogs.app.ws.examples;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeTesting {
    public static void main(String[] args) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println("Current timestamp with date and time: " + formattedDateTime);
    }
}
