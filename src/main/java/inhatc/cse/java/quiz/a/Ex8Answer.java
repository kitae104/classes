package inhatc.cse.java.quiz.a;

import java.util.Arrays;
import java.util.List;

public class Ex8Answer {

    public static void main(String[] args) {
        List<String> sentences = List.of(
                "Java stream is powerful",
                "Stream API is useful",
                "java lambda"
        );

        List<String> words = sentences.stream()
                .flatMap(line -> Arrays.stream(line.split("\\s+")))
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .toList();

        System.out.println(words);
    }
}
