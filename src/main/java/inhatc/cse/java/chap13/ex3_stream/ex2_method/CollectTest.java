package inhatc.cse.java.chap13.ex3_stream.ex2_method;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectTest {
    public static void main(String[] args) {
        Predicate<Integer> isPositive = x -> x > 0;

        List<Integer> numbers = Arrays.asList(5, -10, -22, 0, 43, 7);
        List<Integer> positiveNumbers = numbers.stream()
                .filter(isPositive)
                .collect(Collectors.toList());
        System.out.println(positiveNumbers);

        long count = numbers.stream()
                .filter(isPositive)
                .count();
        System.out.println(count);

        List<Integer> list = numbers.stream()
                .filter(isPositive)
                .sorted()
                .toList();
        System.out.println(list);

    }
}