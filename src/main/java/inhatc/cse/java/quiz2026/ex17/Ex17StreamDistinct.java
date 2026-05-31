package inhatc.cse.java.quiz2026.ex17;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 난이도: 중
 * distinct - 중복 요소 제거
 */
public class Ex17StreamDistinct {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5);
        
        System.out.println("원본: " + numbers);
        
        // distinct()로 중복된 요소 제거
        List<Integer> unique = numbers.stream()
                                       .distinct()  // 중복 제거
                                       .collect(Collectors.toList());
        
        System.out.println("중복 제거후: " + unique);
    }
}

