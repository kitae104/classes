package inhatc.cse.java.quiz.a;

import java.util.Comparator;
import java.util.List;

public class Ex5Answer {

    public static void main(String[] args) {
        List<Integer> scores = List.of(55, 80, 70, 92, 67, 100, 88);

        List<Integer> result = scores.stream()
                .filter(score -> score >= 70)
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println(result);
    }
}
