package inhatc.cse.java.quiz.a;

import java.util.List;
import java.util.Optional;

public class Ex9Answer {

    record User(int id, String name) {
    }

    public static Optional<String> findNameById(List<User> users, int id) {
        return users.stream()
                .filter(user -> user.id() == id)
                .map(User::name)
                .findFirst();
    }

    public static void main(String[] args) {
        List<User> users = List.of(
                new User(1, "Kim"),
                new User(2, "Lee"),
                new User(3, "Park")
        );

        System.out.println(findNameById(users, 2).orElse("UNKNOWN"));
        System.out.println(findNameById(users, 99).orElse("UNKNOWN"));
    }
}
