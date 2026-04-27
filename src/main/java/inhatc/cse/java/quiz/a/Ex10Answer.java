package inhatc.cse.java.quiz.a;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Ex10Answer {

    record Customer(String name, String city, int age) {
    }

    public static void main(String[] args) {
        List<Customer> customers = List.of(
                new Customer("A", "Seoul", 20),
                new Customer("B", "Seoul", 30),
                new Customer("C", "Busan", 40),
                new Customer("D", "Busan", 22),
                new Customer("E", "Incheon", 28)
        );

        Map<String, Double> avgByCity = customers.stream()
                .collect(Collectors.groupingBy(
                        Customer::city,
                        TreeMap::new,
                        Collectors.averagingInt(Customer::age)
                ));

        avgByCity.forEach((city, avg) -> System.out.printf("%s=%.1f%n", city, avg));
    }
}
