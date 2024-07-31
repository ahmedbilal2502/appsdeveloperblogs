package com.appsdeveloperblogs.app.ws.examples;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Collection;

public class FlatMap {
    public static void main(String[] args) {
        List<List<Integer>> nestedList = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6));

        List<Integer> flattenedList = nestedList.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        System.out.println(flattenedList); // Output: [1, 2, 3, 4, 5, 6]

    }
}
