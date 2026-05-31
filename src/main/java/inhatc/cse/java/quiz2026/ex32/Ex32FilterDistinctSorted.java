package inhatc.cse.java.quiz2026.ex32;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 난이도: 상
 * filter + distinct + sorted 다중 조합
 */
public class Ex32FilterDistinctSorted {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(50, 30, 40, 30, 60, 20, 50, 45, 30);
        
        System.out.println("원본: " + numbers);
        
        // filter -> distinct -> sorted 순서로 처리
        List<Integer> result = numbers.stream()
                                       .filter(n -> n >= 30)  // 30 이상만 선택
                                       .distinct()  // 중복 제거
                                       .sorted()  // 오름차순 정렬
                                       .collect(Collectors.toList());
        
        System.out.println("30 이상, 중복제거, 정렬 후: " + result);
    }
}

