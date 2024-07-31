package com.appsdeveloperblogs.app.ws.examples;

import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class filteredAndMapped {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> filteredAndMapped = numbers.stream()
                .filter(num -> num % 2 == 0)
                .map(num -> num * 2)
                .collect(Collectors.toList());

        System.out.println(filteredAndMapped);
    }
}
