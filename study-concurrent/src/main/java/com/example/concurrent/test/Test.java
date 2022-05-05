package com.example.concurrent.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {


    public static void main(String[] args) {


        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);


        Stream<Integer> integerStream1 = integers.stream().map(integer -> {
            System.out.println("map1-" + integer);
            return integer;
        });
        System.out.println("----1------:" + integerStream1);

        Stream<Integer> integerStream2 = integerStream1.map(integer -> {
            System.out.println("map2-" + integer);
            return integer;
        });

        System.out.println("----2------:" + integerStream2);


        Stream<Integer> integerStream3 = integerStream2.filter(integer -> {
            System.out.println("filter3-" + integer);
            return true;
        });

        System.out.println("----3------:" + integerStream3);

        integerStream3.collect(Collectors.toList());

    }
}
