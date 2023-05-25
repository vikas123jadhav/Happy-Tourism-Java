package com.tourism.happytourism.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8_streamAPI {

    public static void main(String[] args) {


        List<Number> list = new ArrayList<>();
        list.add(2);
        list.add(23);
        list.add(4);
        list.add(52);
        list.add(00);

        //Collection.forEach(Consumer) is used to retrieved data one by one and parameter is lambada to read one by one
        //Collection.stream().forEach() is used to print the data one by one coming from stream()

//        list.forEach(
//                num -> {
//                    System.out.println(num.intValue() + 12);
//                }
//        );
//
//        System.out.println();
//
//        list.stream().forEach(num -> {
//            System.out.println(num.intValue() + 12);
//        });


        /* .map( val-> return val )            :- parameter type is 'supplier' takes one param and returns one value.
                                                      & returns stream object.


          .filter( val ->  cond )             :- parameter type is 'predicate' takes one param and validate true or false
                                               is cond true stores in stream else it skip that value in stream.
                                               & returns stream object.


         .forEach( val -> sopln(val )        :- parameter type is 'consumer' takes one param returns nothing.
                                                not returns anything
       */

        List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk");
        // Count the empty strings
        long count = strList.stream().filter(val -> val.isEmpty()).count();
        System.out.println("empty strings count :" + count);

        // Count String with length more than 3
        long count1 = strList.stream().filter(val -> val.length() > 3).count();
        System.out.println("Count String with length more than 3 :" + count);

        // Remove all empty Strings from List
        List<String> notEmptyString = strList.stream().filter(val -> !val.isEmpty()).collect(Collectors.toList());
        System.out.println("Remove all empty Strings from List :" + notEmptyString);

        // Count number of String which startswith "a"
        long count2 = strList.stream().filter(val -> val.startsWith("a")).count();
        System.out.println("Count number of String which startswith:" + count2);

        // Create a List with String more than 2 characters
        List<String> listTwoChars = strList.stream().filter(val -> val.length() > 2).collect(Collectors.toList());
        System.out.println("Create a List with String more than 2 characters" + listTwoChars);


        // Convert String to Uppercase and join them using coma
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");
        List<String> listUpper = G7.stream().map(val -> val.toUpperCase()).collect(Collectors.toList());
        System.out.println("Convert String to Uppercase and join them using coma" + listUpper);


        // Create List of square of all distinct numbers
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);

        List<Integer> uniqueSquares = primes.stream().map(num -> num * num).distinct().collect(Collectors.toList());

        //Get count, min, max, sum, and average for numbers

        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map(i -> i * i).distinct()              //  it will return all unique, duplicate/ second same numbers will remove
                .collect(Collectors.toList());

        System.out.println("Distinct numbers :" + distinct);
    }
}
