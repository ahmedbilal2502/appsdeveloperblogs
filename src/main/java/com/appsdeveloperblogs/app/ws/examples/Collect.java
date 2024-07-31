package com.appsdeveloperblogs.app.ws.examples;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Collect {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange");

        String joinedFruits = fruits.stream()
                .collect(Collectors.joining(", "));

        System.out.println(joinedFruits); // Output: Apple, Banana, Orange

    }
}
