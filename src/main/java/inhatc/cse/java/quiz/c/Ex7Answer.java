package inhatc.cse.java.quiz.c;

import java.util.IntSummaryStatistics;
import java.util.List;

public class Ex7Answer {

    public static void main(String[] args) {
        List<List<Integer>> weeklyScores = List.of(
                List.of(70, 80, 90),
                List.of(60, 75),
                List.of(88, 92, 77)
        );

        IntSummaryStatistics stats = weeklyScores.stream()
                .flatMap(List::stream)
                .mapToInt(Integer::intValue)
                .summaryStatistics();

        System.out.println("count=" + stats.getCount());
        System.out.println("min=" + stats.getMin());
        System.out.println("max=" + stats.getMax());
        System.out.printf("avg=%.2f%n", stats.getAverage());
    }
}
