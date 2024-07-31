package com.appsdeveloperblogs.app.ws.examples;

import java.util.*;
import java.util.stream.Collectors;

public class ExampleMain {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Emily", 39),
                new Person("Bob", 25),
                new Person("Charlie", 35),
                new Person("David", 40),
                new Person("Alice", 96)
        );

       List<String> peopleListFilterAgeGreaterThen30= people.stream().filter(x->x.getAge() < 30)
               .map(c->c.getName())
               .sorted()
               .collect(Collectors.toList());


        peopleListFilterAgeGreaterThen30.stream().forEach(System.out::println);

    }
}
