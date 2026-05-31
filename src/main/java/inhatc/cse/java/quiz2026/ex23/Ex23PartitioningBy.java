package inhatc.cse.java.quiz2026.ex23;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 난이도: 중
 * partitioningBy - groupingBy의 특수 형태로 true/false로 분할
 */
public class Ex23PartitioningBy {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 25, 35, 50, 55, 60, 45, 70, 30);
        
        System.out.println("숫자 리스트: " + numbers);
        
        // partitioningBy()로 50 이상과 미만으로 분할
        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                                                          .collect(Collectors.partitioningBy(n -> n >= 50));
        
        System.out.println("\n50 이상: " + partitioned.get(true));
        System.out.println("50 미만: " + partitioned.get(false));
    }
}

