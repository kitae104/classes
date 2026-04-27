package inhatc.cse.java.quiz.b;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex8Answer {

    public static void main(String[] args) {
        List<String> lines = List.of(
                "java stream java",
                "stream api is useful",
                "java api"
        );

        Map<String, Long> freq = lines.stream()
                .flatMap(line -> Arrays.stream(line.toLowerCase().split("\\s+")))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        List<String> top3 = freq.entrySet().stream()
                .sorted(Comparator.<Map.Entry<String, Long>>comparingLong(Map.Entry::getValue)
                        .reversed()
                        .thenComparing(Map.Entry::getKey))
                .limit(3)
                .map(e -> e.getKey() + ":" + e.getValue())
                .toList();

        System.out.println(top3);
    }
}
