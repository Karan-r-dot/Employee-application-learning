package com.example.employee_application.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamPractise {

    // public static void main(String[] args){
    //     List<Integer> numbers = Arrays.asList(10,20,30,40,50);
    //     for(Integer num : numbers){
    //             System.out.println(num);
    // }
    // }

    // public static void main(String[] args){
    //     List<Integer> numbers = Arrays.asList(10,15,20,25,30);
    //     List<Integer> num = numbers.stream().filter(n-> n%2==0).toList();
    //     System.out.println(num);
    // }

    // public static void main(String[] args){
    //     List<Integer> numbers = Arrays.asList(10,15,20,25,30);
    //     List<Integer> num = numbers.stream().filter(n -> n>20).toList();
    //     System.out.println(num);
    // }

    // public static void main(String[] args){
    //     List<Integer> numbers = Arrays.asList(10,20,30);
    //     List<Integer> num = numbers.stream().map(n -> n*2).toList();
    //     System.out.println(num);
    // }

    // public static void main(String[] args){
    //     List<String> names =  Arrays.asList("karan","ramesh","john");
    //     List<String> UpperCaseNames = names.stream().map(name -> name.toUpperCase()).toList();
    //     System.out.println(UpperCaseNames);
    // }

    // public static void main(String[] args){
    //     List<String> names =  Arrays.asList("karan","john","kishore","ramesh");
    //     List<String> filteredNames = names
    //                .stream()
    //                .filter(n -> n.startsWith("k")).map(name -> name.toUpperCase()).toList();
    //     System.out.println(filteredNames);
    // }

    // public static void main(String[] args){
    //     List<Integer> numbers = Arrays.asList(5,10,15,20,25,30);
    //     List<Integer> num = numbers.stream()
    //                                .filter(n1 -> n1>10)
    //                                .map(n2->n2*2)
    //                                .filter(n3->n3>40)
    //                                .toList();
    //     System.out.println(num);
    // }

    // public static void main(String[] args){
    //     List<String> skills =
    //     Arrays.asList(
    //             "Java",
    //             "Spring",
    //             "Java",
    //             "Docker",
    //             "Spring",
    //             "Kafka"
    //     );
    //     List<String> skill = skills.stream()
    //                                .distinct()
    //                                .map(s -> s.toUpperCase())
    //                                .sorted().toList();
    //     System.out.println(skill);
    // }

    // public static void main(String[] args){
    //     List<Integer> numbers = Arrays.asList(10,50,40,70,80,20);
    //     Optional<Integer> number = numbers.stream()
    //                                   .sorted(Comparator.reverseOrder())
    //                                   .skip(1)
    //                                   .findFirst();
    //     System.out.println(number);
    // }

    // public static void main(String[] args){
    //     List<String> names = Arrays.asList( "Karan","Ramesh","John", "David");
    //     List<Character> name = names.stream()
    //                              .map(n -> n.charAt(1))
    //                              .toList();
    //     System.out.println(name);
       
    // }

    // public static void main(String[] args){
    //     List<String> names =
    //     Arrays.asList(
    //             "Karan",
    //             "Ramesh",
    //             "Kishore",
    //             "Kiran",
    //             "John"
    //     );

    //     Long namecount = names.stream().filter(n -> n.startsWith("K")).count();
    //     System.out.println(namecount);
    // }

    // public static void main(String[] args){
    //     List<String> names =
    //     Arrays.asList(
    //             "Java",
    //             "Spring",
    //             "Hibernate",
    //             "API"
    //     );

    //     String name = names.stream().sorted(Comparator.reverseOrder()).findFirst().toString();

    //     System.out.println(name);
    // }

    // public static void main(String[] args){
    // List<String> names =
    //     Arrays.asList(
    //             "Java",
    //             "Spring",
    //             "Hibernate",
    //             "API"
    //     );

    // Optional<String> name = names.stream().max(Comparator.comparing(String::length));

    // System.out.println(name);
    // }

    public static void main(String[] args){

        List<Integer> list = Arrays.asList(10,20,40,20,50);

        Set<Integer> s = new HashSet<>();

        Set<Integer> dup= list.stream()
                              .filter(n -> !s.add(n)).collect(Collectors.toSet());

        System.out.println(dup);
        
    }


}
