package inhatc.cse.java.quiz.c;

import java.util.List;
import java.util.Optional;

public class Ex9Answer {

    record Address(String zip) {
    }

    record User(String name, Address address) {
    }

    public static Optional<String> findZipByName(List<User> users, String name) {
        return users.stream()
                .filter(user -> user.name().equals(name))
                .findFirst()
                .map(User::address)
                .map(Address::zip);
    }

    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Kim", new Address("11111")),
                new User("Lee", null),
                new User("Park", new Address("33333"))
        );

        System.out.println(findZipByName(users, "Kim").orElse("NO_ZIP"));
        System.out.println(findZipByName(users, "Lee").orElse("NO_ZIP"));
        System.out.println(findZipByName(users, "Choi").orElse("NO_ZIP"));
    }
}
