package com.learning._8.stream.examples;

import com.learning._8.stream.model.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamExample5 {

    public static void main(String[] args) {

        /**
         * Finding Distinct Items by Multiple Fields
         */

        List<Person> pList = Arrays.asList(
                new Person(1234, "Eve", "", 27),
                new Person(2345, "Lyn", "Fam", 20),
                new Person(2347, "Lyn", "Fam", 24)
        );

        List<Person> distinctPerson = pList.stream()
                .filter(distinctByKeys(Person::firstName, Person::lastName))
                .toList();
    }

    private static <T> Predicate<T> distinctByKeys(final Function<? super T, ?>... keyExtractors)
    {
        final Map<List<?>, Boolean> seen = new ConcurrentHashMap<>();

        return t -> {
            final List<?> keys = Arrays.stream(keyExtractors)
                    .map(ke -> ke.apply(t))
                    .collect(Collectors.toList());

            return seen.putIfAbsent(keys, Boolean.TRUE) == null;
        };
    }

}
