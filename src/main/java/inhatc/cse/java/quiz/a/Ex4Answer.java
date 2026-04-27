package inhatc.cse.java.quiz.a;

import java.util.List;

public class Ex4Answer {

    public static <T extends Comparable<? super T>> long countGreaterThan(List<T> values, T pivot) {
        return values.stream()
                .filter(v -> v.compareTo(pivot) > 0)
                .count();
    }

    public static void main(String[] args) {
        List<Integer> values = List.of(3, 7, 1, 9, 5);
        System.out.println(countGreaterThan(values, 4));
    }
}
