package inhatc.cse.java.quiz.b;

import java.util.Comparator;
import java.util.List;

public class Ex6Answer {

    record Employee(String name, int salary, int year) {
    }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Kim", 4200, 3),
                new Employee("Lee", 5000, 5),
                new Employee("Park", 4200, 4),
                new Employee("Choi", 3800, 2)
        );

        employees.stream()
                .sorted(Comparator.comparingInt(Employee::salary)
                        .reversed()
                        .thenComparing(Employee::name))
                .forEach(System.out::println);
    }
}
