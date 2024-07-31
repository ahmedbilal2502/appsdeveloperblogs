package com.appsdeveloperblogs.app.ws.examples;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class OfficeExample {
    public static void main(String[] args) {
        LocalDate localDate=LocalDate.now();
        System.out.println(localDate);
        double totalPrice=0.0;
        BigDecimal roundedTotalPrice = BigDecimal.valueOf(totalPrice).setScale(2, RoundingMode.HALF_UP);
        System.out.println(roundedTotalPrice.doubleValue());
    }
}
