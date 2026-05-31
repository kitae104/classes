package inhatc.cse.java.quiz2026.ex16;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 난이도: 중
 * sorted - Comparator.reverseOrder()를 사용한 내림차순 정렬
 */
public class Ex16SortedDesc {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(45, 23, 78, 12, 56, 89, 34, 67);
        
        System.out.println("원본: " + numbers);
        
        // MapToInt 후 내림차순 정렬
        List<Integer> sorted = numbers.stream()
                                       .sorted((a, b) -> b.compareTo(a))  // 내림차순
                                       .collect(Collectors.toList());
        
        System.out.println("내림차순: " + sorted);
    }
}

