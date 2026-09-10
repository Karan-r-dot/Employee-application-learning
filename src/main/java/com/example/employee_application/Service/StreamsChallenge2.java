// package com.example.employee_application.Service;

// import java.util.List;
// import java.util.Map;
// import java.util.Optional;
// import java.util.OptionalDouble;
// import java.util.Set;
// import java.util.stream.Collectors;

// import org.apache.kafka.common.protocol.types.Field.Bool;

// import com.example.employee_application.EmployeeApplication;

// import java.util.Arrays;
// import java.util.Comparator;

// public class StreamsChallenge2 {

//     public static void main(String[] args) {

//         List<Employee> employees = Arrays.asList(

//                 new Employee(
//                         101,
//                         "Karan",
//                         "IT",
//                         70000,
//                         25
//                 ),

//                 new Employee(
//                         102,
//                         "John",
//                         "HR",
//                         45000,
//                         30
//                 ),

//                 new Employee(
//                         103,
//                         "Ramesh",
//                         "IT",
//                         90000,
//                         32
//                 ),

//                 new Employee(
//                         104,
//                         "Kishore",
//                         "Finance",
//                         50000,
//                         22
//                 ),

//                 new Employee(
//                         105,
//                         "Arun",
//                         "IT",
//                         70000,
//                         28
//                 ),

//                 new Employee(
//                         106,
//                         "David",
//                         "Sales",
//                         80000,
//                         35
//                 ),

//                 new Employee(
//                         107,
//                         "Raja",
//                         "Sales",
//                         60000,
//                         27
//                 ),

//                 new Employee(
//                         108,
//                         "Ram",
//                         "IT",
//                         90000,
//                         29
//                 )
//         );

//         // List<Employee> result = employees.stream().filter(e -> e.getDepartment().contains("IT"))
//         //                          .toList();

//         //List<String> result = employees.stream().map(Employee::getName).toList();

//         // List<String> result = employees.stream().filter(e -> e.getSalary()>70000).map(e1 -> e1.getName()).toList();
         
//         // List<String> result = employees.stream().map(Employee::getName).map(String::toUpperCase).toList();

//         // List<String> result = employees.stream().map(Employee::getDepartment).distinct().toList();

//         //Optional<Employee> result = employees.stream().max(Comparator.comparing(Employee::getSalary));

//         //Long result = employees.stream().filter(e -> e.getDepartment().contains("IT")).count();

//         // Boolean result = employees.stream().anyMatch(emp -> emp.getSalary()>90000);
//         // Boolean result = employees.stream().allMatch(e -> e.getAge()>21);
//         // Boolean result = employees.stream().noneMatch(e -> e.getDepartment().contains("Admin"));

//         // Optional<Employee> result = employees.stream().filter(e->e.getDepartment().contains("Sales")).findFirst();
//         // Map<String,List<Employee>> result = employees.stream().
//         //                        collect(Collectors.groupingBy(Employee::getDepartment));

//         // Map<String,Long> result = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));

//         // List<String> result = employees.stream().map(Employee::getName).map(String::toLowerCase).sorted().toList();

//         // List<String> result = employees.stream().filter(e1 -> e1.getAge()<30 && e1.getSalary()>60000).map(Employee::getName).toList();

//         // OptionalDouble result = employees.stream().mapToDouble(Employee::getSalary).average();

//         // List<String> result = employees.stream().filter(emp -> emp.getSalary()>=60000 && emp.getSalary()<=80000).map(Employee::getName).toList();

//         // Double result1 = employees.stream().mapToDouble(Employee::getSalary).average().orElse(0);
//         // List<String> result = employees.stream().filter(e -> e.getSalary() > result1).map(Employee::getName).toList();

//         // Double result1 = employees.stream().map(Employee::getSalary).distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null);
//         // Employee result = employees.stream().filter(e->e.getSalary()==result1).findFirst().orElse(null);

//         //  Employee result = employees.stream().filter(e->e.getName().startsWith("R")).max(Comparator.comparing(Employee::getSalary)).orElse(null);

//         // Map<String,Long> result = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));

//         // Map<String,List<String>> result = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.mapping(Employee::getName, Collectors.toList())));

//         // Map<String,Double> result = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.summingDouble(Employee::getSalary)));

//         // Map<String,Set<String>> result = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.mapping(Employee::getName, Collectors.toSet())));

//         // Map<String,Long> result = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));

//         // Map<String,Optional<Employee>> result = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

//         // Map<String,String> result = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.mapping(Employee::getName,Collectors.joining(","))));

//         // Map<Boolean,List<Employee>> result = employees.stream().collect(Collectors.partitioningBy(e -> e.getSalary()>=50000));

//         // Map<Boolean,Long> result = employees.stream().collect(Collectors.partitioningBy(e->e.getSalary()>=50000,Collectors.counting()));

//          Map<Boolean,List<String>> result = employees.stream().collect(Collectors.partitioningBy(e->e.getSalary()>=50000,Collectors.mapping(Employee::getName,Collectors.toList())));
        
        
//         System.out.println(result);
//     }

// }

// class Employee {

//     private int id;
//     private String name;
//     private String department;
//     private double salary;
//     private int age;

//     public Employee(
//             int id,
//             String name,
//             String department,
//             double salary,
//             int age) {

//         this.id = id;
//         this.name = name;
//         this.department = department;
//         this.salary = salary;
//         this.age = age;
//     }

//     public int getId() {
//         return id;
//     }

//     public String getName() {
//         return name;
//     }

//     public String getDepartment() {
//         return department;
//     }

//     public double getSalary() {
//         return salary;
//     }

//     public int getAge() {
//         return age;
//     }

//     @Override
//     public String toString() {

//         return "Employee{" +
//                 "id=" + id +
//                 ", name='" + name + '\'' +
//                 ", department='" + department + '\'' +
//                 ", salary=" + salary +
//                 ", age=" + age +
//                 '}';
//     }
// }
