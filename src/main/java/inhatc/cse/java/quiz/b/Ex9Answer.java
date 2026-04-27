package inhatc.cse.java.quiz.b;

import java.util.List;
import java.util.Optional;

public class Ex9Answer {

    public static Optional<Integer> parsePositiveInt(String input) {
        if (input == null) {
            return Optional.empty();
        }

        try {
            int value = Integer.parseInt(input.trim());
            return value > 0 ? Optional.of(value) : Optional.empty();
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public static void main(String[] args) {
        List<String> inputs = List.of("10", "0", "-3", "abc", "7");
        inputs.forEach(s -> System.out.println(s + " -> " + parsePositiveInt(s).orElse(-1)));

        System.out.println("null -> " + parsePositiveInt(null).orElse(-1));
    }
}
