package inhatc.cse.java.quiz.a;

import java.util.List;
import java.util.stream.Collectors;

public class Ex6Answer {

    record Person(String name, int age) {
    }

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("alice", 19),
                new Person("bob", 22),
                new Person("chris", 27),
                new Person("david", 17)
        );

        String joined = people.stream()
                .filter(p -> p.age() >= 20)
                .map(p -> p.name().toUpperCase())
                .sorted()
                .collect(Collectors.joining(", "));

        System.out.println(joined);
    }
}
