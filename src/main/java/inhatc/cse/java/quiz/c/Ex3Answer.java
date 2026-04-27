package inhatc.cse.java.quiz.c;

import java.util.List;

public class Ex3Answer {

    public static double sumNumbers(List<? extends Number> numbers) {
        return numbers.stream()
                .mapToDouble(Number::doubleValue)
                .sum();
    }

    public static void main(String[] args) {
        System.out.println(sumNumbers(List.of(1, 2, 3, 4)));
        System.out.println(sumNumbers(List.of(1.5, 2.0, 3.5)));
    }
}
