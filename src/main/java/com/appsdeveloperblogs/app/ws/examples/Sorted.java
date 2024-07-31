package com.appsdeveloperblogs.app.ws.examples;

import java.util.*;
import java.util.stream.Collectors;

public class Sorted {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9);

        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(sortedNumbers); // Output: [1, 2, 5, 8, 9]

    }
}
