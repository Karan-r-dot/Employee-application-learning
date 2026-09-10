package com.example.employee_application.Service;

// import java.util.Arrays;
// import java.util.List;

// public class HardStreamChallenge {

//     public static void main(String[] args) {

//         List<Employee> employees = Arrays.asList(

//             new Employee(
//                 101,
//                 "Karan",
//                 "IT",
//                 70000,
//                 25
//             ),

//             new Employee(
//                 102,
//                 "John",
//                 "HR",
//                 45000,
//                 30
//             ),

//             new Employee(
//                 103,
//                 "Ramesh",
//                 "IT",
//                 90000,
//                 32
//             ),

//             new Employee(
//                 104,
//                 "Kishore",
//                 "Finance",
//                 50000,
//                 22
//             ),

//             new Employee(
//                 105,
//                 "Arun",
//                 "IT",
//                 60000,
//                 28
//             ),

//             new Employee(
//                 106,
//                 "Karan",
//                 "IT",
//                 80000,
//                 26
//             )
//         );

//         /*
//          * YOUR TASK:
//          *
//          * 1. Convert employees into a Stream.
//          * 2. Keep only employees from the "IT" department.
//          * 3. Keep only employees whose salary is at least 70000.
//          * 4. Convert each Employee object into the employee's name.
//          * 5. Convert every name to uppercase.
//          * 6. Remove duplicate names.
//          * 7. Sort the names alphabetically.
//          * 8. Store the final result in List<String>.
//          * 9. Print the result.
//          *
//          * Do not use a normal for loop.
//          *
//          * Methods you may use:
//          *
//          * stream()
//          * filter()
//          * map()
//          * distinct()
//          * sorted()
//          * toList()
//          */

//         // Write your Stream code below

//         List<String> empoutput = employees.stream()  
//                                             .filter(e1 -> e1.getDepartment().contains("IT"))
//                                             .filter(e2 -> e2.getSalary()>70000)
//                                             .map(e3 -> e3.getName())
//                                             .map(e4 -> e4.toUpperCase())
//                                             .distinct().sorted().toList();

//         System.out.println(empoutput);

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
//         return name
//                 + " - "
//                 + department
//                 + " - "
//                 + salary;
//     }
// }

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class HardStreamChallenge {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(

                new Employee(
                        101,
                        "Karan",
                        "IT",
                        70000,
                        25
                ),

                new Employee(
                        102,
                        "John",
                        "HR",
                        45000,
                        30
                ),

                new Employee(
                        103,
                        "Ramesh",
                        "IT",
                        90000,
                        32
                ),

                new Employee(
                        104,
                        "Kishore",
                        "Finance",
                        50000,
                        22
                ),

                new Employee(
                        105,
                        "Arun",
                        "IT",
                        70000,
                        28
                ),

                new Employee(
                        106,
                        "David",
                        "Sales",
                        80000,
                        35
                ),

                new Employee(
                        107,
                        "Karan",
                        "Sales",
                        60000,
                        27
                ),

                new Employee(
                        108,
                        "Ram",
                        "IT",
                        90000,
                        29
                )
        );

        /*
         * ======================================================
         * TASK 1: HIGHEST SALARY EMPLOYEE
         * ======================================================
         *
         * Find the employee having the highest salary.
         *
         * Use:
         * stream()
         * max()
         * Comparator.comparing()
         * Employee::getSalary
         *
         * Store result in:
         *
         * Optional<Employee>
         *
         * Expected employee:
         *
         * Ramesh or Ram
         *
         * Both have salary 90000, so max() may return
         * the first maximum employee in encounter order.
         */

        // Write Task 1 here

        // Optional<Employee> employee = employees.stream().max(Comparator.comparing(Employee::getSalary));
        // System.out.println(employee);
        /*
         * ======================================================
         * TASK 2: LOWEST SALARY EMPLOYEE NAME
         * ======================================================
         *
         * Find the employee with the lowest salary.
         *
         * Then extract only the employee's name.
         *
         * Use:
         * stream()
         * min()
         * Comparator.comparing()
         * Employee::getSalary
         * map()
         * Employee::getName
         * orElse()
         *
         * Store result in:
         *
         * String lowestSalaryEmployeeName
         *
         * Expected output:
         *
         * John
         */

        // Write Task 2 here


        /*
         * ======================================================
         * TASK 3: SECOND-HIGHEST DISTINCT SALARY
         * ======================================================
         *
         * 1. Convert Employee objects into salaries.
         * 2. Remove duplicate salaries.
         * 3. Sort salaries in descending order.
         * 4. Skip the highest salary.
         * 5. Find the next salary.
         * 6. If it is unavailable, return 0.0.
         *
         * Use:
         * stream()
         * map()
         * Employee::getSalary
         * distinct()
         * sorted(Comparator.reverseOrder())
         * skip(1)
         * findFirst()
         * orElse()
         *
         * Store result in:
         *
         * Double secondHighestSalary
         *
         * Expected output:
         *
         * 80000.0
         */
        // Optional<Double> employee = employees.stream().map(Employee::getSalary).distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        // System.out.println(employee);
        // Write Task 3 here


        /*
         * ======================================================
         * TASK 4: EMPLOYEES WITH SECOND-HIGHEST SALARY
         * ======================================================
         *
         * Use the secondHighestSalary calculated in Task 3.
         *
         * 1. Keep employees whose salary equals
         *    secondHighestSalary.
         * 2. Extract their names.
         * 3. Convert names to uppercase.
         * 4. Sort alphabetically.
         * 5. Store in List<String>.
         *
         * Use:
         * stream()
         * filter()
         * map()
         * Employee::getName
         * String::toUpperCase
         * sorted()
         * toList()
         *
         * Expected output:
         *
         * [DAVID]
         */
        // Double employee = employees.stream()
        //                        .map(Employee::getSalary)
        //                        .distinct()
        //                        .sorted(Comparator.reverseOrder())
        //                        .skip(1)
        //                        .findFirst().orElse(0.0);

        // List<String> employee1 = employees.stream() 
        //                                    .filter(e -> e.getSalary() == employee)
        //                                    .map(Employee::getName)
        //                                    .map(String::toUpperCase)
        //                                    .sorted()
        //                                    .toList();

        // System.out.println(employee1);
        // Write Task 4 here


        /*
         * ======================================================
         * TASK 5: UNIQUE IT EMPLOYEE NAMES
         * ======================================================
         *
         * 1. Keep only employees from the IT department.
         * 2. Keep employees whose salary is at least 70000.
         * 3. Extract their names.
         * 4. Convert names to uppercase.
         * 5. Remove duplicate names.
         * 6. Sort names alphabetically.
         * 7. Store in List<String>.
         *
         * Expected output:
         *
         * [ARUN, KARAN, RAM, RAMESH]
         */

        // Write Task 5 here
        // List<String> employee = employees.stream()
        //                                    .filter(e -> e.getDepartment().contains("IT"))
        //                                    .filter(e1 -> e1.getSalary()>=70000)
        //                                    .map(Employee::getName)
        //                                    .map(String::toUpperCase)
        //                                    .distinct()
        //                                    .sorted()
        //                                    .toList();
        // System.out.println(employee);

            


        /*
         * ======================================================
         * TASK 6: OLDEST EMPLOYEE
         * ======================================================
         *
         * Find the oldest employee.
         *
         * Use:
         * stream()
         * max()
         * Comparator.comparing()
         * Employee::getAge
         * map()
         * Employee::getName
         * orElse()
         *
         * Store result in:
         *
         * String oldestEmployeeName
         *
         * Expected output:
         *
         * David
         */

        // Write Task 6 here


        /*
         * ======================================================
         * TASK 7: SORT EMPLOYEES BY SALARY THEN NAME
         * ======================================================
         *
         * Sort employees:
         *
         * 1. Salary in descending order.
         * 2. If two employees have the same salary,
         *    sort those employees by name alphabetically.
         *
         * Use:
         * Comparator.comparing()
         * reversed()
         * thenComparing()
         * Employee::getSalary
         * Employee::getName
         *
         * Store result in:
         *
          List<Employee> sortedEmployees
         */

        // List<Employee> sortedEmployees = employees.stream()
        //                    .sorted(Comparator.comparing(Employee::getSalary).reversed().thenComparing(Employee::getName))
        //                    .toList();
        // Write Task 7 here
 

        /*
         * ======================================================
         * TASK 8: CHECK BUSINESS CONDITIONS
         * ======================================================
         *
         * A. Check whether at least one employee earns
         *    more than 85000.
         *
         * B. Check whether all employees are at least
         *    18 years old.
         *
         * C. Check whether no employee has a negative salary.
         *
         * Use:
         * anyMatch()
         * allMatch()
         * noneMatch()
         *
         * Expected:
         *
         * A = true
         * B = true
         * C = true
         */

        // Write Task 8 here

        Boolean employee = employees.stream().anyMatch(emp -> emp.getSalary()>85000);
        Boolean employee1 = employees.stream().allMatch(emp1 -> emp1.getAge()>=18);
        Boolean employee2 = employees.stream().noneMatch(emp2 -> emp2.getSalary()<0);
        System.out.println(employee);
        System.out.println(employee1);
        System.out.println(employee2);


        /*
         * ======================================================
         * TASK 9: COUNT IT EMPLOYEES
         * ======================================================
         *
         * Count employees belonging to IT.
         *
         * Use:
         * stream()
         * filter()
         * count()
         *
         * Store result in:
         *
         * long itEmployeeCount
         *
         * Expected output:
         *
         * 4
         */

        // Write Task 9 here


        /*
         * ======================================================
         * TASK 10: LONGEST EMPLOYEE NAME
         * ======================================================
         *
         * 1. Extract employee names.
         * 2. Find the longest name.
         * 3. If no name is available, return "Not Found".
         *
         * Use:
         * stream()
         * map()
         * Employee::getName
         * max()
         * Comparator.comparingInt()
         * String::length
         * orElse()
         *
         * Expected output:
         *
         * Kishore
         */

        // Write Task 10 here
    }
}


class Employee {

    private int id;
    private String name;
    private String department;
    private double salary;
    private int age;

    public Employee(
            int id,
            String name,
            String department,
            double salary,
            int age) {

        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {

        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}