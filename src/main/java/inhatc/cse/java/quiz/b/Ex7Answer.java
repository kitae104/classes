package inhatc.cse.java.quiz.b;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex7Answer {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        Map<Boolean, List<Integer>> partition = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println("even=" + partition.get(true));
        System.out.println("odd=" + partition.get(false));
    }
}
