package com.appsdeveloperblogs.app.ws.examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Request {
    private String value;

    public Request(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static void main(String[] args) {
        List<String> spinTheWheelIgnoreValueConfigList = Arrays.asList("apple", "banana", "cherry");
        Request request = new Request(" BaNaNa sPLit ");

        // Preprocess request value: lowercase and remove all spaces
        String processedValue = request.getValue().toLowerCase().replaceAll("\\s+", "");

        System.out.println(processedValue); // Output: true, because "banana" is a substring of "bananasplit"

        boolean result = spinTheWheelIgnoreValueConfigList.stream()
                .map(String::toLowerCase) // Ensure list elements are also in lowercase
                .anyMatch(processedValue::contains);

        System.out.println(result); // Output: true, because "banana" is a substring of "bananasplit"
    }
}

