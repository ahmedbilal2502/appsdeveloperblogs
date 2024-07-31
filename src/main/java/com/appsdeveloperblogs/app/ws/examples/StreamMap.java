package com.appsdeveloperblogs.app.ws.examples;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class StreamMap {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        List<Integer> nameLengths = names.stream()
                .map(x->x.length())
                .collect(Collectors.toList());

        System.out.println(nameLengths);

    }
}
