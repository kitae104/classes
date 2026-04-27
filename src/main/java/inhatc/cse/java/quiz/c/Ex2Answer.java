package inhatc.cse.java.quiz.c;

import java.util.Comparator;
import java.util.List;

public class Ex2Answer {

    record StudentScore(String name, int score) {
    }

    public static void main(String[] args) {
        List<StudentScore> scores = List.of(
                new StudentScore("Kim", 90),
                new StudentScore("Lee", 85),
                new StudentScore("Park", 90),
                new StudentScore("Choi", 70)
        );

        scores.stream()
                .sorted(Comparator.comparingInt(StudentScore::score)
                        .reversed()
                        .thenComparing(StudentScore::name))
                .forEach(System.out::println);
    }
}
