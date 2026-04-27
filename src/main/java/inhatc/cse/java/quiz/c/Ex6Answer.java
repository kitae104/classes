package inhatc.cse.java.quiz.c;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Ex6Answer {

    public static void main(String[] args) {
        List<String> words = List.of("apple", "ant", "banana", "boat", "cat", "candy", "car");

        Comparator<String> byLengthThenAlphabet = Comparator
                .comparingInt(String::length)
                .thenComparing(Comparator.naturalOrder());

        Map<String, String> longestByInitial = words.stream()
                .collect(Collectors.groupingBy(
                        word -> word.substring(0, 1),
                        TreeMap::new,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(byLengthThenAlphabet),
                                optional -> optional.orElse("")
                        )
                ));

        System.out.println(longestByInitial);
    }
}
