package inhatc.cse.java.quiz.b;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Ex4Answer {

    public static void main(String[] args) {
        List<String> words = List.of("java", "db", "spring", "ai", "stream", "oop");

        Map<Integer, List<String>> grouped = new TreeMap<>();
        for (String word : words) {
            grouped.computeIfAbsent(word.length(), k -> new ArrayList<>()).add(word);
        }

        grouped.forEach((len, list) -> System.out.println(len + "=" + list));
    }
}
